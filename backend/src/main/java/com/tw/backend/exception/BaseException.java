package com.tw.backend.exception;

import java.util.Map;

public interface BaseException {
    Map<String, ?> getMapForResponse();
}
