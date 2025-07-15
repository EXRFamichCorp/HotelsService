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
    public ProblemDetail hotelNotFoundExceptionHandler(NotFoundException e, WebRequest request){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setType(URI.create("https://tools.ietf.org/html/rfc7807"));
        problemDetail.setTitle("Not Found");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setStatus(HttpStatus.NOT_FOUND.value());
        problemDetail.setInstance(URI.create(request.getDescription(false)));
        return problemDetail;
    }

    @ExceptionHandler(ConflictException.class)
    public ProblemDetail handleConflict(ConflictException ex, WebRequest request) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setType(URI.create("https://api.errors/conflict"));
        problem.setTitle("Conflict");
        problem.setDetail(ex.getMessage());
        problem.setInstance(URI.create(request.getDescription(false)));
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }



}
