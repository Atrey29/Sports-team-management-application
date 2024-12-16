package org.openapitools.exceptions;

public class MessageNotValidException extends RuntimeException {
    public MessageNotValidException() {
        super();
    }
    public MessageNotValidException(String msg) {
        super(msg);
    }
}
