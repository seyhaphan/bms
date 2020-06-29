package com.kshrd.bms.exception;

import com.kshrd.bms.rest.response.ErrorResponse;
import com.kshrd.bms.rest.response.Messages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;


@ControllerAdvice
public class AppGlobalException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> error (ResponseStatusException e){
       return ResponseEntity.ok(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorResponse> handleError(NumberFormatException e){
        return ResponseEntity.ok(new ErrorResponse(e.getMessage()));
    }
}
