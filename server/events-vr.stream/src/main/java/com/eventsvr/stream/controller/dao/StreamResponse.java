package com.eventsvr.stream.controller.dao;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class StreamResponse {

    private HttpStatus status;

    private String url;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(int id, int frame) {
        this.url = id + "/" + frame + ".jpg";
    }
}
