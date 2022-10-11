package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * @author meow
 */
public interface WebAppError {

    HttpStatus getStatusCode();

    String getErrorCode();

    WebAppException exception();
}
