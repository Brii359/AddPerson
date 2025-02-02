package com.example.main.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (Long id) {
        super("Could not Found the User Id"+ id);
    }
}
