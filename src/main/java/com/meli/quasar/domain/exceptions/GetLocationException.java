package com.meli.quasar.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GetLocationException extends RuntimeException {

    public GetLocationException(String errorMessage) {
        super(errorMessage);
    }
}
