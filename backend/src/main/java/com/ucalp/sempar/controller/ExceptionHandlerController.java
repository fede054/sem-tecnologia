package com.ucalp.sempar.controller;

import com.ucalp.sempar.dto.rs.ErrorRsDTO;
import com.ucalp.sempar.exception.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorRsDTO> handleInvalidRequest(final InvalidRequestException e) {
        final ErrorRsDTO errorToReturn = new ErrorRsDTO(e.getDescription());
        return new ResponseEntity<>(errorToReturn, HttpStatus.BAD_REQUEST);
    }


}
