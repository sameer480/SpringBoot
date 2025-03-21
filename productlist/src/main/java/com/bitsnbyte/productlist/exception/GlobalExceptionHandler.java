package com.bitsnbyte.productlist.exception;

import com.bitsnbyte.productlist.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException ex, WebRequest request) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(request.getDescription(false), ex.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);

    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCategoryNotFoundException(CategoryNotFoundException ex, WebRequest request) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(request.getDescription(false), ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleGlobalException(CategoryNotFoundException ex, WebRequest request) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(request.getDescription(false), ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
    }
}
