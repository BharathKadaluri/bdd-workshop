package com.nineleaps.bdd.exceptions;

public class InvalidPathException extends RuntimeException{
    private String message;

    public InvalidPathException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
