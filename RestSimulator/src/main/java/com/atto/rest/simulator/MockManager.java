package com.atto.rest.simulator;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class MockManager {
    private HashMap<String, String> dataMapper = new HashMap<String, String>();
    
    public String get(String path){
        return dataMapper.get(path);
    }
    
    public void add(String path, String data){
        dataMapper.put(path, data);
    }
}
