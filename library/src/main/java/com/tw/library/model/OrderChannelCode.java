package com.tw.library.model;

public enum OrderChannelCode {

    AMAZON(Constants.AMAZON),
    EBAY(Constants.EBAY),
    INTERNAL(Constants.INTERNAL);

    private final String code;

    private OrderChannelCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return code;
    }

    public static class Constants {
        public static final String AMAZON = "AMAZON";
        public static final String EBAY = "EBAY";
        public static final String INTERNAL = "INTERNAL";
    }
}