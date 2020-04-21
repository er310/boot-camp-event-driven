package com.tw.library.model;

public enum JmsServiceCode {

    TOPIC_INVENTORY(Constants.TOPIC_INVENTORY),
    QUEUE_INVENTORY(Constants.QUEUE_INVENTORY),
    TOPIC_INVENTORY_COSTUME(Constants.TOPIC_INVENTORY_COSTUME),
    QUEUE_INVENTORY_COSTUME(Constants.QUEUE_INVENTORY_COSTUME),

    TOPIC_BACKEND(Constants.TOPIC_BACKEND),
    QUEUE_BACKEND(Constants.QUEUE_BACKEND);

    private final String code;

    private JmsServiceCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return code;
    }

    public static class Constants {
        public static final String TOPIC_INVENTORY = "TOPIC.INVENTORY";
        public static final String QUEUE_INVENTORY = "QUEUE.INVENTORY";
        public static final String TOPIC_INVENTORY_COSTUME = "TOPIC.INVENTORY.COSTUME";
        public static final String QUEUE_INVENTORY_COSTUME = "QUEUE.INVENTORY.COSTUME";

        public static final String TOPIC_BACKEND = "TOPIC.BACKEND";
        public static final String QUEUE_BACKEND = "QUEUE.BACKEND";
    }
}