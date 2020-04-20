package com.tw.library.exception;

public class JmsBrokerException extends ApiRuntimeBaseException {

    static final long serialVersionUID = 10003L;

    public JmsBrokerException(String message, ErrorCode code) {
        super(message, code);
    }
}
