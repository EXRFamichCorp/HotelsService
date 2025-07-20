package ru.fomin.hotels.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ConflictException extends RuntimeException {

    private final String code;

    private final Map<String, Object> dictionary = new HashMap<>();

    public ConflictException(String code,String message) {
        super(message);
        this.code = code;
    }

    public ConflictException(String code) {
        this.code = code;
    }

}