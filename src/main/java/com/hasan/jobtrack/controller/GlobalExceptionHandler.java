package com.hasan.jobtrack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class) @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,Object> runtime(RuntimeException ex){ return Map.of("timestamp", LocalDateTime.now(), "error", ex.getMessage()); }
    @ExceptionHandler(MethodArgumentNotValidException.class) @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> validation(MethodArgumentNotValidException ex){ Map<String,Object> res=new HashMap<>(); Map<String,String> errors=new HashMap<>(); ex.getBindingResult().getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage())); res.put("timestamp", LocalDateTime.now()); res.put("errors", errors); return res; }
}
