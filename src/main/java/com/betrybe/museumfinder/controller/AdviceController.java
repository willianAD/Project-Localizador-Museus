package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class AdviceController.
 */
@ControllerAdvice
public class AdviceController {
  
  @ExceptionHandler
  public ResponseEntity<String> handlerCoordinateException(InvalidCoordinateException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
  }
  
  @ExceptionHandler
  public ResponseEntity<String> handlerNotFoundException(MuseumNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
  }
  
  @ExceptionHandler
  public ResponseEntity<String> handlerException(Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}
