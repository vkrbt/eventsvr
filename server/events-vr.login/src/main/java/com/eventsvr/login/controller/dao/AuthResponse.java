package com.eventsvr.login.controller.dao;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class AuthResponse {
    private Date timestamp;

    private HttpStatus status;

    private String message;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
