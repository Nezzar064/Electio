package com.msn.codeexam.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
  protected ResponseEntity<Object> handleIllegalArgumentOrState(RuntimeException ex, WebRequest request) {
    String responseMsg = "Application Specific Error has occurred";
    return handleExceptionInternal(ex, responseMsg, new HttpHeaders(), HttpStatus.CONFLICT, request);
  }

  @ExceptionHandler(DataNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage handleDataNotFound(DataNotFoundException ex, WebRequest request) {
    return new ErrorMessage(
        HttpStatus.NOT_FOUND.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
  }
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage handleInternalServerError(Exception ex, WebRequest request) {
    return new ErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
  }

}