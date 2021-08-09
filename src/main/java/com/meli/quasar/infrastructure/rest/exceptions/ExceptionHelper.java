package com.meli.quasar.infrastructure.rest.exceptions;

import com.meli.quasar.domain.exceptions.GetLocationException;
import com.meli.quasar.domain.exceptions.GetMessageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "com.meli.quasar*")
@Slf4j
public class ExceptionHelper extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { GetMessageException.class })
    @ResponseStatus(value = HttpStatus.NOT_FOUND )
    public String HandleGetMessageException(GetMessageException ex) {
        log.trace(ex.getMessage());
        return ex.getMessage();
    }

    @ExceptionHandler(value = { GetLocationException.class })
    public ResponseEntity<String> HandleGetLocationException(GetLocationException ex) {
        log.trace(ex.getMessage());
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<String> handleGenericException(Exception ex) {
        log.trace(ex.getMessage());
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
