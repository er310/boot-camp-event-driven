package com.tw.library.exception;

import com.tw.library.data.Result;

public interface BaseException {
    Result<?> getResponse();
}
