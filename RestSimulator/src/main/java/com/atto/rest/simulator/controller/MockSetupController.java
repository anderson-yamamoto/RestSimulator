package com.atto.rest.simulator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atto.rest.simulator.MockManager;

@RestController
@RequestMapping(value = "/setup")
public class MockSetupController {
    
    @Autowired
    MockManager mockManager;
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<String> getMockedData(final HttpServletRequest request, @RequestBody MockHttpRequest mock) {
        mockManager.add(mock.getMethod().name() + mock.getUrl(), mock.getRequest());
        return new ResponseEntity<String>("Setup", HttpStatus.OK);
    }

}
