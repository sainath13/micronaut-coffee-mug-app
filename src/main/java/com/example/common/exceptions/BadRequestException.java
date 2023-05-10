package com.example.common.exceptions;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;

public class BadRequestException extends HttpStatusException{
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
