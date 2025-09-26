package com.api.maping_jpa.exptionalHandling;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleExceptionValidation(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error)->{
            String fieldError = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldError,errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintException(ConstraintViolationException exc){
        Map<String, String> errors = new HashMap<>();
        exc.getConstraintViolations().forEach(violation -> {
            String errorField = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(errorField,errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
