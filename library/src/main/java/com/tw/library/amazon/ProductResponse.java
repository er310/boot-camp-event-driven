package com.tw.library.amazon;

import com.tw.library.model.Condition;
import com.tw.library.model.SellStatus;

import java.time.ZonedDateTime;

public class ProductResponse {
    protected final String refNo;
    protected final Condition condition;
    protected final String description;
    protected final SellStatus status;
    protected final ZonedDateTime deliveryDateTime;

    public ProductResponse(final String refNo, final SellStatus status) {
        this.refNo = refNo;
        this.condition = null;
        this.description = null;
        this.status = status;
        this.deliveryDateTime = null;
    }

    public ProductResponse(final String refNo, final Condition condition,
                           final String description, final SellStatus status) {
        this.refNo = refNo;
        this.condition = condition;
        this.description = description;
        this.status = status;
        this.deliveryDateTime = null;
    }

    public ProductResponse(final String refNo, final Condition condition,
                           final String description, final SellStatus status, final ZonedDateTime deliveryDateTime) {
        this.refNo = refNo;
        this.condition = condition;
        this.description = description;
        this.status = status;
        this.deliveryDateTime = deliveryDateTime;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getDescription() {
        return this.description;
    }

    public SellStatus getStatus() {
        return this.status;
    }

    public ZonedDateTime getDeliveryDateTime() {
        return this.deliveryDateTime;
    }
}
