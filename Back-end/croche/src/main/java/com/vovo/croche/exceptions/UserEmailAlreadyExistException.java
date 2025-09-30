package com.vovo.croche.exceptions;

public class UserEmailAlreadyExistException extends RuntimeException {
    public UserEmailAlreadyExistException(String message) {
        super(message);
    }
}
