package com.tw.library.model;

public enum JmsServiceCode {

    TOPIC_BACKEND(Constants.TOPIC_BACKEND),
    QUEUE_BACKEND(Constants.QUEUE_BACKEND),

    TOPIC_INVENTORY(Constants.TOPIC_INVENTORY),
    QUEUE_INVENTORY(Constants.QUEUE_INVENTORY),
    TOPIC_INVENTORY_COSTUME(Constants.TOPIC_INVENTORY_COSTUME),
    QUEUE_INVENTORY_COSTUME(Constants.QUEUE_INVENTORY_COSTUME),

    TOPIC_ORDER(Constants.TOPIC_ORDER),
    QUEUE_ORDER(Constants.QUEUE_ORDER),
    TOPIC_ORDER_COSTUME(Constants.TOPIC_ORDER_COSTUME),
    QUEUE_ORDER_COSTUME(Constants.QUEUE_ORDER_COSTUME),

    TOPIC_AMAZON(Constants.TOPIC_AMAZON),
    QUEUE_AMAZON(Constants.QUEUE_AMAZON),
    TOPIC_AMAZON_ORDER(Constants.TOPIC_AMAZON_ORDER),
    QUEUE_AMAZON_ORDER(Constants.QUEUE_AMAZON_ORDER),

    TOPIC_EBAY(Constants.TOPIC_EBAY),
    QUEUE_EBAY(Constants.QUEUE_EBAY),
    TOPIC_EBAY_ORDER(Constants.TOPIC_EBAY_ORDER),
    QUEUE_EBAY_ORDER(Constants.QUEUE_EBAY_ORDER),

    TOPIC_SELL(Constants.TOPIC_SELL),
    QUEUE_SELL(Constants.QUEUE_SELL),
    TOPIC_SELL_ORDER(Constants.TOPIC_SELL_ORDER),
    QUEUE_SELL_ORDER(Constants.QUEUE_SELL_ORDER);

    private final String code;

    private JmsServiceCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return this.code;
    }

    public static class Constants {
        public static final String TOPIC_BACKEND = "TOPIC.BACKEND";
        public static final String QUEUE_BACKEND = "QUEUE.BACKEND";

        public static final String TOPIC_INVENTORY = "TOPIC.INVENTORY";
        public static final String QUEUE_INVENTORY = "QUEUE.INVENTORY";
        public static final String TOPIC_INVENTORY_COSTUME = "TOPIC.INVENTORY.COSTUME";
        public static final String QUEUE_INVENTORY_COSTUME = "QUEUE.INVENTORY.COSTUME";

        public static final String TOPIC_ORDER = "TOPIC.ORDER";
        public static final String QUEUE_ORDER = "QUEUE.ORDER";
        public static final String TOPIC_ORDER_COSTUME = "TOPIC.ORDER.COSTUME";
        public static final String QUEUE_ORDER_COSTUME = "QUEUE.ORDER.COSTUME";

        public static final String TOPIC_AMAZON = "TOPIC.AMAZON";
        public static final String QUEUE_AMAZON = "QUEUE.AMAZON";
        public static final String TOPIC_AMAZON_ORDER = "TOPIC.AMAZON.ORDER";
        public static final String QUEUE_AMAZON_ORDER = "QUEUE.AMAZON.ORDER";

        public static final String TOPIC_EBAY = "TOPIC.AMAZON";
        public static final String QUEUE_EBAY = "QUEUE.AMAZON";
        public static final String TOPIC_EBAY_ORDER = "TOPIC.EBAY.ORDER";
        public static final String QUEUE_EBAY_ORDER = "QUEUE.EBAY.ORDER";

        public static final String TOPIC_SELL = "TOPIC.SELL";
        public static final String QUEUE_SELL = "QUEUE.SELL";
        public static final String TOPIC_SELL_ORDER = "TOPIC.SELL.ORDER";
        public static final String QUEUE_SELL_ORDER = "QUEUE.SELL.ORDER";
    }
}