package org.prvn.labs.order.processing.orderservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


// global exception handler for controller related exceptions
@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleConstraintViolationException(MethodArgumentNotValidException e) {

        List<String> errors = new ArrayList<>();
        e.getAllErrors().forEach(error ->
                errors.add(error.getDefaultMessage()) );
        return ResponseEntity.badRequest().body(errors);
    }
}