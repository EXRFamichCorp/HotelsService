package ru.fomin.hotels.exception;

public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message);
    }

}