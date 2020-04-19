package com.tw.library.exception;

public class RecordNotFoundBaseException extends ApiRuntimeBaseException {

    static final long serialVersionUID = 10002L;

    public RecordNotFoundBaseException(String message, ErrorCode code) {
        super(message, code);
    }
}
