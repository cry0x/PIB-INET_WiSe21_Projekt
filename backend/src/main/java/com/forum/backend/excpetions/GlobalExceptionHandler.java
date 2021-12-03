package com.forum.backend.excpetions;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PSQLException.class)
    public ResponseEntity<String> handlePSQLException(PSQLException psqlException) {
        if (psqlException.getSQLState().equals("23505")) {
            return new ResponseEntity<>("Could not create user! Unique key constraint violation.", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(psqlException.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
