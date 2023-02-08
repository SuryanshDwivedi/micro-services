package com.cmp.userservice.user.exceptions;

import com.cmp.userservice.user.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ApiResponse> handleResourceNotFound(ResourceNotFoundException ex)
    {
        ApiResponse msg = ApiResponse.builder().message(ex.getMessage()).StatusCode(HttpStatus.NOT_FOUND).success(true).build();

        return new ResponseEntity<ApiResponse>(msg, HttpStatus.NOT_FOUND);
    }
}
