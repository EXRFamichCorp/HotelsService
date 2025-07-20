package ru.fomin.hotels.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.fomin.hotels.exception.ConflictException;
import ru.fomin.hotels.exception.NotFoundException;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail NotFoundExceptionHandler(NotFoundException exception, WebRequest request){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setType(URI.create("https://tools.ietf.org/html/rfc7807"));
        problemDetail.setTitle(exception.getCode());
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setInstance(URI.create(request.getDescription(false)));
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setProperties(exception.getDictionary());
        return problemDetail;
    }

    @ExceptionHandler(ConflictException.class)
    public ProblemDetail ConflictExceptionHandler(ConflictException exception, WebRequest request) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setType(URI.create("https://tools.ietf.org/html/rfc7807"));
        problem.setTitle(exception.getCode());
        problem.setDetail(exception.getMessage());
        problem.setInstance(URI.create(request.getDescription(false)));
        problem.setProperty("timestamp", Instant.now());
        problem.setProperties(exception.getDictionary());
        return problem;
    }



}
