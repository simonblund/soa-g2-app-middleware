package com.g2.appmiddleware.interfaces.rest;

import com.g2.appmiddleware.api.rest.ErrorResponse;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandler{

    public ResponseEntity<com.g2.appmiddleware.api.rest.ErrorResponse> handle(Exception e){
        com.g2.appmiddleware.api.rest.ErrorResponse error = ErrorResponse.builder().code(500).message(e.getMessage()).build();

        return ResponseEntity.status(500).body(error);
    }
}
