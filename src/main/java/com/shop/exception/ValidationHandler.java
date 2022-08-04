package com.shop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ValidationHandler {

//    @ExceptionHandler(value = ConstraintViolationException.class)
//    public ResponseEntity<Object> handleMobileSize(ConstraintViolationException exception){
//        return new ResponseEntity<>("please enter valid details", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
//    public ResponseEntity<Object> handleDuplicateEntry(SQLIntegrityConstraintViolationException exception){
//        return new ResponseEntity<>("phone number and email already used",HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(value = NoSuchElementException.class)
//    public ResponseEntity<Object> handleDuplicateEntry(NoSuchElementException exception){
//        return new ResponseEntity<>("No data found",HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(value = EmptyResultDataAccessException.class)
//    public ResponseEntity<Object> handleDuplicateEntry(EmptyResultDataAccessException exception){
//        return new ResponseEntity<>("record not found",HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
