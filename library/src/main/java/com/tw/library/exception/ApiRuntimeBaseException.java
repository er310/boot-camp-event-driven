package com.tw.library.exception;

import com.tw.library.data.Result;

public class ApiRuntimeBaseException extends RuntimeException implements BaseException {

    static final long serialVersionUID = 10001L;
    private ErrorCode code;
    private ExceptionResponse response;

    public ApiRuntimeBaseException(String message, ErrorCode code) {
        super(message);

        this.code = code;
        this.response = new ExceptionResponse(code.getValue(), getMessage());
    }

    public Result<?> getResponse() {
        return response.getResponse();
    }
}