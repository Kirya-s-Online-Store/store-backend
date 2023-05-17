package com.online.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such user")
public class UserNotRegisteredException extends RuntimeException {

    public UserNotRegisteredException(String message) {
        super(message);
    }
}
