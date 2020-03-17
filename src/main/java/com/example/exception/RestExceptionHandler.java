package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dto.ReturnDetail;

@RestControllerAdvice
public class RestExceptionHandler
{
    @ExceptionHandler(value = { InvalidPayloadException.class })
    public ResponseEntity<ReturnDetail> badRequest(Exception ex)
    {
        return new ResponseEntity<>(new ReturnDetail().setCode(400).setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase()).setDetail(ex.getMessage()), HttpStatus.BAD_REQUEST);

    }
    
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ReturnDetail> unKnownException(Exception ex)
    {
        return new ResponseEntity<>(new ReturnDetail().setCode(500).setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).setDetail(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}