package com.example.demo.exception;

import lombok.Getter;

/**
 * @author meow
 */
@Getter
public class WebAppException extends RuntimeException{

    private final WebAppError error;

    public WebAppException(WebAppError error) {
        this.error = error;
    }
}
