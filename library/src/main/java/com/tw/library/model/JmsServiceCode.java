package com.tw.library.model;

public enum JmsServiceCode {

    TOPIC_INVENTORY("TOPIC.INVENTORY"),
    QUEUE_INVENTORY("QUEUE.INVENTORY"),
    TOPIC_INVENTORY_COSTUME("TOPIC.INVENTORY.COSTUME"),
    QUEUE_INVENTORY_COSTUME("QUEUE.INVENTORY.COSTUME"),

    TOPIC_BACKEND("TOPIC.BACKEND"),
    QUEUE_BACKEND("QUEUE.BACKEND");

    private final String code;

    private JmsServiceCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return code;
    }
}