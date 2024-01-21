package com.dagy.cafeheroapi.core.exceptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TransientPropertyValueException;
import org.hibernate.exception.SQLGrammarException;
import org.modelmapper.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler extends RuntimeException {
    public static final String ERROR_OCCURRED = "An error occurred";
    public static final String ERROR_VALIDATION = "We are afraid, you missed something:";
    public static final String INTERNAL_ERROR_OCCURRED = "Please try again later, something went wrong and it's not your fault.";
    public static final String ERROR_DUPLICATE = "Oops, there is duplicate";
    public static final String ERROR_BAD_CREDENTIALS = "Invalid credentials";
    public static final String CONNECTION_EXCEPTION = "Connection to third party failed.";

    @ExceptionHandler(value = SQLGrammarException.class)
    public ResponseEntity<Object> handleSQLGrammarException(SQLGrammarException exception) {
        HttpStatus badRequest = INTERNAL_SERVER_ERROR;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, List.of(INTERNAL_SERVER_ERROR.getReasonPhrase()), badRequest.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        HttpStatus badRequest = INTERNAL_SERVER_ERROR;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, List.of(exception.getMessage()), badRequest.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
        HttpStatus error = HttpStatus.UNAUTHORIZED;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(error, List.of(exception.getMessage()), error.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(value = TransientPropertyValueException.class)
    public ResponseEntity<Object> handleETransientPropertyValueException(TransientPropertyValueException exception) {
        HttpStatus error = HttpStatus.UNAUTHORIZED;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(error, List.of(exception.getMessage()), error.value(),
                        ERROR_VALIDATION
                ));

    }

    @ExceptionHandler(value = MappingException.class)
    public ResponseEntity<Object> handleMappingException(MappingException exception) {
        HttpStatus error = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(error, List.of(exception.getMessage()), error.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(value = org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception
    ) {
        HttpStatus error = BAD_REQUEST;
        String message = exception.getLocalizedMessage();
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(error, List.of(message), error.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> err = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> err.add(error.getDefaultMessage()));
        HttpStatus badRequest = BAD_REQUEST;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, err, badRequest.value(), ERROR_VALIDATION));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomExceptionResponse> handleHttpMessageNotReadableExceptions(
            HttpMessageNotReadableException ex
    ) {
        List<String> err = new ArrayList<>();
        String message = ex.getMessage();
        if (message != null) {
            String[] split = message.split(":");
            err.add(split[0]);
        } else {
            err.add("Http Request Is Not Readable or Missing Required Parameter");
        }
        HttpStatus badRequest = BAD_REQUEST;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, err, badRequest.value(), ERROR_VALIDATION));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomExceptionResponse> handleConstraintViolationException(
            ConstraintViolationException ex
    ) {
        List<String> err = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(
                Collectors.toList());
        HttpStatus badRequest = BAD_REQUEST;
        return ResponseEntity.badRequest().body(new CustomExceptionResponse(badRequest, err, badRequest.value()));
    }

}
