package com.tyc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    USER_NOT_REGISTERED(1001, "User didn't register", INTERNAL_SERVER_ERROR),
    USER_NOT_LOGIN(1002, "User didn't login", INTERNAL_SERVER_ERROR),
    USER_ALREADY_EXISTS(1003, "User already exists", INTERNAL_SERVER_ERROR),
    USER_NOT_FIND(1004, "User didn't find", INTERNAL_SERVER_ERROR),
    INVALID_ACTIVATION_ERROR(1005, "Invalid user activation code", INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(1006, "Invalid token", INTERNAL_SERVER_ERROR),
    ROLE_NOT_FIND(1007, "Role didn't find", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
