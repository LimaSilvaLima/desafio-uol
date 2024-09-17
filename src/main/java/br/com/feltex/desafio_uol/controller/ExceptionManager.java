package br.com.feltex.desafio_uol.controller;

import java.util.NoSuchElementException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionManager {
	
	@ExceptionHandler(NoSuchElementException.class)
	public String handleNoSuchElementException(NoSuchElementException e) {
		log.info("Entidade não encontrada" , e);
		return ResponseEntity.badRequest().body(e.getMessage()).toString();
		
	}

}
