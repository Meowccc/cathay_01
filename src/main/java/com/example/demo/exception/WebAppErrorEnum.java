package com.example.demo.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author meow
 */
@RequiredArgsConstructor
public enum WebAppErrorEnum implements WebAppError{

    COIN_NOT_FOUND(HttpStatus.NOT_FOUND, "CON00001"),

    COIN_DESK_NOT_FOUND(HttpStatus.NOT_FOUND, "CON00001"),
    ;
    private final HttpStatus statusCode;
    private final String errorCode;


    @Override
    public HttpStatus getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public WebAppException exception() {
        return new WebAppException(this);
    }
}
