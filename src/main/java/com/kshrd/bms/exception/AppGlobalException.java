package com.kshrd.bms.exception;

import com.kshrd.bms.rest.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;


@ControllerAdvice
public class AppGlobalException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> error (ResponseStatusException e){
       return ResponseEntity.ok(new ErrorResponse(e.getStatus(),e.getReason()));
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorResponse> handleError(NumberFormatException e){
        return ResponseEntity.ok(new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage()));
    }
}
