package org.openapitools.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super();
    }
    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
