package org.openapitools.exceptions;

public class EmptyRepositoryException extends RuntimeException {
    public EmptyRepositoryException() {
        super();
    }
    public EmptyRepositoryException(String msg) {
        super(msg);
    }
}
