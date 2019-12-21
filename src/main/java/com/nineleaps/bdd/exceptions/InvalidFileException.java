package com.nineleaps.bdd.exceptions;

public class InvalidFileException extends RuntimeException {
    private String message;

    public InvalidFileException(String message) {
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
