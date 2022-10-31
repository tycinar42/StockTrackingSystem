package com.tyc.exception;

import lombok.Getter;

@Getter
public class ProductStockManagerException extends RuntimeException {
    private final ErrorType errorType;
    public ProductStockManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ProductStockManagerException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
}
