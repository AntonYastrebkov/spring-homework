package com.epam.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserRoleException.class)
    public ResponseEntity userRoleHandler(UserRoleException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity userRoleHandler(EmailExistsException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskOverflowException.class)
    public ResponseEntity userRoleHandler(TaskOverflowException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userRoleHandler(UserNotFoundException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(WrongPassword.class)
    public ResponseEntity userRoleHandler(WrongPassword e) {
        System.out.println(e.getMessage());
        return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity unresolvedException(Exception e) {
        System.out.println("Something bad happened...\n" + e.getMessage());
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
