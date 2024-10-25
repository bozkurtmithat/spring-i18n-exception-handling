package mbozkurt.core.messaging.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import mbozkurt.core.messaging.model.ClientMessage;
import mbozkurt.core.messaging.model.MessageException;


@RestControllerAdvice
public class GlobalMessageExceptionHandler {

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<ClientMessage> handleCustomException(MessageException ex) {
        return new ResponseEntity<ClientMessage>(ex.getClientMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

	
}
