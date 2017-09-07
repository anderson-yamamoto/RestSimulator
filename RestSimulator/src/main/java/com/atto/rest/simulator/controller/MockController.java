package com.atto.rest.simulator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.atto.rest.simulator.MockManager;

@RestController
@RequestMapping(value = "/mock")
public class MockController {
    
    @Autowired
    MockManager mockManager;
    
    
    public ResponseEntity<String> mockedData(RequestMethod method, final HttpServletRequest request) {

        String finalPath = extractPath(request);
        String content = mockManager.get(method.name() + finalPath);
        if (content != null)
            return new ResponseEntity<String>(content, HttpStatus.OK);
        else
            return new ResponseEntity<String>("Mock not found.", HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/**", method=RequestMethod.GET)
    public ResponseEntity<String> mockedDataForGet(final HttpServletRequest request) {
        return mockedData(RequestMethod.GET, request);
    }
    
    @RequestMapping(value = "/**", method=RequestMethod.PUT)
    public ResponseEntity<String> mockedDataForPut(final HttpServletRequest request) {
        return mockedData(RequestMethod.PUT, request);
    }
    
    @RequestMapping(value = "/**", method=RequestMethod.POST)
    public ResponseEntity<String> mockedDataForPost(final HttpServletRequest request) {
        return mockedData(RequestMethod.POST, request);
    }
    
    @RequestMapping(value = "/**", method=RequestMethod.DELETE)
    public ResponseEntity<String> mockedDataForDelete(final HttpServletRequest request) {
        return mockedData(RequestMethod.DELETE, request);
    }

    private String extractPath(final HttpServletRequest request) {
        String path = (String) request.getAttribute(
            HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String ) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);

        AntPathMatcher apm = new AntPathMatcher();
        String finalPath = apm.extractPathWithinPattern(bestMatchPattern, path);
        return finalPath;
    }
}
