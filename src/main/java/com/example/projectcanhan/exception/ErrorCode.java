package com.example.projectcanhan.exception;

public enum ErrorCode {

    USER_EXISTS(1001, "User Already Exists"),
    USER_NOT_FOUND(1002, "User Not Found"),
    INVALID_REQUEST(1003, "Invalid Request"),
    PRODUCT_EXISTS(1004, "Product Already Exists"),
    PRODUCT_NOT_FOUND(1005, "Product Not Found");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
