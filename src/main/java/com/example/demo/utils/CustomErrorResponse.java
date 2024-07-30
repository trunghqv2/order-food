package com.example.demo.utils;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse {
    private String message;
    private HttpStatus status;

    public CustomErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

}
