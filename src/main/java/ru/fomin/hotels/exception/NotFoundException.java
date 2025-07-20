package ru.fomin.hotels.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class NotFoundException extends RuntimeException {

    private final String code;

    private final Map<String, Object> dictionary = new HashMap<>();

    public NotFoundException(String code,String message) {
        super(message);
        this.code = code;

    }

    public NotFoundException(String code){
        this.code = code;
    }

}
