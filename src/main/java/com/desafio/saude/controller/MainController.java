package com.desafio.saude.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public class MainController {
	
	private final  Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<String>  handleMissingParams(MissingServletRequestParameterException e) {
	    
		String response = ("Parametro " + e.getParameterName() + " obrigatorio");
	    logger.error(response);
	    
	    return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String>  handleInvalidParams(MethodArgumentTypeMismatchException e) {
	    
		String response = (e.getParameter() + " possui valor invalido");
	    logger.error(response);
	    
	    return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
	}
}
