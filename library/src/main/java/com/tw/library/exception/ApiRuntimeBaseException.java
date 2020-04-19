package com.tw.library.exception;

import java.util.Map;

public class ApiRuntimeBaseException extends RuntimeException implements BaseException {

    static final long serialVersionUID = 10001L;
    protected ErrorCode code;
    private ExceptionResponse response;

    public ApiRuntimeBaseException(String message, ErrorCode code) {
        super(message);

        this.code = code;
        this.response = new ExceptionResponse(code.getValue(), getMessage());
    }

    public Map<String, ?> getMapForResponse() {
        return response.getMapForResponse();
    }
}