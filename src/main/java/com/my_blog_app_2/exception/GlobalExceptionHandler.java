package com.my_blog_app_2.exception;

import com.my_blog_app_2.payload.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> GlobalExceptionHandler(Exception e, WebRequest webRequest)
    {
        ExceptionDto exceptionDto=new ExceptionDto(new Date(),e.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<> (exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
