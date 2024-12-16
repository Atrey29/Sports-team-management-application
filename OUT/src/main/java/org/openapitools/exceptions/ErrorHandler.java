package org.openapitools.exceptions;

import org.openapitools.model.*;
import org.openapitools.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.UUID;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> handleException1(RuntimeException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(new ResponseHeader().sendDate(new Date()).requestId(UUID.randomUUID()));
        error.code("500");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleException2(HttpMessageNotReadableException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(new ResponseHeader().sendDate(new Date()).requestId(UUID.randomUUID()));
        error.code("400");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Error> handleException3(BadCredentialsException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(new ResponseHeader().sendDate(new Date()).requestId(UUID.randomUUID()));
        error.code("401");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Error> handleException4(UserAlreadyExistsException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(new ResponseHeader().sendDate(new Date()).requestId(UUID.randomUUID()));
        error.code("500");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserDoesntExistsException.class)
    public ResponseEntity<Error> handleException5(UserDoesntExistsException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(new ResponseHeader().sendDate(new Date()).requestId(UUID.randomUUID()));
        error.code("500");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyRepositoryException.class)
    public ResponseEntity<Error> handleException5(EmptyRepositoryException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(new ResponseHeader().sendDate(new Date()).requestId(UUID.randomUUID()));
        error.code("500");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MessageNotValidException.class)
    public ResponseEntity<Error> handleException5(MessageNotValidException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(new ResponseHeader().sendDate(new Date()).requestId(UUID.randomUUID()));
        error.code("500");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}