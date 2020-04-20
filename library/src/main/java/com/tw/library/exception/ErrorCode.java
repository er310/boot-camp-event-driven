package com.tw.library.exception;

public enum ErrorCode {

    OBJECT_NOT_FOUND(100),
    OBJECT_IS_INVALID(101),

    NO_HANDLER_FOUND(200),
    SERVER_EXCEPTION(201),
    JMS_EXCEPTION(202);

    private final int code;

    private ErrorCode(int code) {
        this.code = code;
    }

    public int getValue() {
        return code;
    }
}