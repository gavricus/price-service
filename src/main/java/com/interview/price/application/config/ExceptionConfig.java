package com.interview.price.application.config;

import com.interview.price.interfaces.rest.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
public class ExceptionConfig {

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiResponse handleNoHandlerFound(NoHandlerFoundException e) {
    log.error(e.getMessage(), e);
    return new ApiResponse(e.getMessage());
  }

  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiResponse bindingHandler(BindException e) {
    log.error(e.getMessage(), e);
    return e.getFieldErrors().stream().findFirst().map(
      error -> new ApiResponse(error.getField() + " " + error.getDefaultMessage())
    ).orElse(ApiResponse.UNKNOWN_ERROR);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ApiResponse internalError(Exception e) {
    log.error(e.getMessage(), e);
    return new ApiResponse(e.getMessage());
  }
}
