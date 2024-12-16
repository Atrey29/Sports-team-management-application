package org.openapitools.exceptions;

public class UserDoesntExistsException extends RuntimeException{
    public UserDoesntExistsException() {
        super();
    }
    public UserDoesntExistsException(String msg) {
        super(msg);
    }
}
