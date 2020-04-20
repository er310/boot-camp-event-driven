package com.tw.library.exception;

import com.tw.library.data.Result;

public class ApiBaseException extends Exception implements BaseException {

    static final long serialVersionUID = 10000L;
    private ErrorCode code;
    private ExceptionResponse response;

    public ApiBaseException(String message, ErrorCode code) {
        super(message);

        this.code = code;
        this.response = new ExceptionResponse(code.getValue(), getMessage());
    }

    public Result<?> getResponse() {
        return response.getResponse();
    }
}