package com.example.volvo.exceptions;

import com.example.volvo.api.response.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        Optional<FieldError> first = ex.getBindingResult().getFieldErrors().stream().filter(
                e -> Objects.requireNonNull(e.getDefaultMessage()).contains("param error")
        ).findFirst();
        return first.map(fieldError -> ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(fieldError.getDefaultMessage()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unknown error"));
    }

    @ExceptionHandler(BizException.class)
    public ResponseEntity<Error> handleBizException(BizException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new Error(ex.getBizError().getErrorCode(), ex.getBizError().getErrorMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}
