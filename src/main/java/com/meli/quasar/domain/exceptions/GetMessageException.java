package com.meli.quasar.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GetMessageException extends RuntimeException {

    public GetMessageException(String errorMessage) {
        super(errorMessage);
    }
}
