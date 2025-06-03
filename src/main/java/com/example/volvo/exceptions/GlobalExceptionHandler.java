package com.example.volvo.exceptions;

import com.example.volvo.controller.response.CommonResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse<?> handleValidationException(MethodArgumentNotValidException ex) {
        Optional<FieldError> first = ex.getBindingResult().getFieldErrors().stream().filter(
                e -> Objects.requireNonNull(e.getDefaultMessage()).contains("business error")
        ).findFirst();
        return first.isPresent() ? CommonResponse.error(first.get().getDefaultMessage()) : CommonResponse.error("unknown error");
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse<?> handleException(Exception ex) {
        return CommonResponse.error(ex.getMessage());
    }
}
