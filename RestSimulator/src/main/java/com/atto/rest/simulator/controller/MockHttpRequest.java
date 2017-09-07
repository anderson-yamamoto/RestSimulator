package com.atto.rest.simulator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

public class MockHttpRequest {
    private String request;
    private HttpStatus status;
    private String url;
    private RequestMethod  method;

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = RequestMethod.valueOf(method);
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = HttpStatus.valueOf(status);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
