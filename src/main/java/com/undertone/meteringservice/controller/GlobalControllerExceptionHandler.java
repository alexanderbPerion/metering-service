package com.undertone.meteringservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {


  @Autowired
  private ObjectMapper objectMapper;

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(Exception.class)
  public void error(Exception e, HttpServletRequest request) throws JsonProcessingException {

    final String path = request.getPathInfo();

    final Map<String, String[]> parameterMap = request.getParameterMap();

    final String parameterMapString = objectMapper.writeValueAsString(parameterMap);

    log.error("Error while calling path: " + path + " with parameters: " + parameterMapString, e);
  }
}
