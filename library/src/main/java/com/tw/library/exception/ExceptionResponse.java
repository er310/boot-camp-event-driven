package com.tw.library.exception;

import com.tw.library.data.Result;
import com.tw.library.data.Status;

public class ExceptionResponse {

    private final Result<?> result;

    public ExceptionResponse(int code, String message) {
        result = new Result<>(Status.FAIL, code, message);
    }

    public Result<?> getResponse() {
        return this.result;
    }
}