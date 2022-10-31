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
    PRODUCTSTOCK_NOT_CREATE(1009, "Product stock didn't create", INTERNAL_SERVER_ERROR),
    PRODUCTSTOCK_NOT_UPDATE(1010, "Product stock didn't update", INTERNAL_SERVER_ERROR),
    PRODUCTSTOCK_NOT_DELETE(1011, "Product stock didn't delete", INTERNAL_SERVER_ERROR),
    PRODUCTSTOCK_ALREADY_EXISTS(1012, "Product stock already exists", INTERNAL_SERVER_ERROR),
    PRODUCTSTOCK_NOT_FIND(1013, "Product stock didn't find", INTERNAL_SERVER_ERROR),
    INVALID_ACTIVATION_ERROR(1005, "Invalid user activation code", INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(1006, "Invalid token", INTERNAL_SERVER_ERROR),
    ROLE_NOT_FIND(1007, "Role didn't find", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
