package com.jt.devicemanagement.exceptionHandlers;

import com.jt.devicemanagement.exceptions.EntityNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<Object> HandleEmptyResultDataAccessException(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> HandleAllExceptions(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>(exception.getMessage() + "for request" + request.getDescription(true), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Doesn't work
//    @ExceptionHandler({ConstraintViolationException.class, TransactionSystemException.class})
//    public ResponseEntity<Object> HandleConstraintViolationException(ConstraintViolationException exception, WebRequest request) {
//        ConstraintViolation v = (ConstraintViolation) exception.getConstraintViolations().toArray()[0];
//        return new ResponseEntity<Object>(v.getPropertyPath() + " " + v.getMessage(), HttpStatus.BAD_REQUEST);
//    }

}
