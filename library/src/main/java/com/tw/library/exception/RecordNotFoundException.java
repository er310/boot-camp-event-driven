package com.tw.library.exception;

public class RecordNotFoundException extends ApiRuntimeBaseException {

    static final long serialVersionUID = 10002L;

    public RecordNotFoundException(String message, ErrorCode code) {
        super(message, code);
    }
}
