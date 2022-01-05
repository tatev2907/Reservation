package com.example.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotAuthenticatedException extends RuntimeException {

    public UserNotAuthenticatedException(Long userId) {
        super("Flight not found" + userId + "");
    }

}
