package com.thoughtworks.capability.gtb.restfulapidesign.interceptor;

import com.thoughtworks.capability.gtb.restfulapidesign.error.ErrorResult;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler( StudentNotFoundException.class)
    public ResponseEntity<ErrorResult> handler(Exception ex) {
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
