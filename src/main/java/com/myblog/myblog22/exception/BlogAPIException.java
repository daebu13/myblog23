package com.myblog.myblog22.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException {
    public BlogAPIException(HttpStatus httpStatus,String s) {
        super();
    }
}
