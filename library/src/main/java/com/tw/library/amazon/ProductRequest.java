package com.tw.library.amazon;

import com.tw.library.model.Condition;

public class ProductRequest {
    protected final String refNo;
    protected final Condition condition;
    protected final String description;

    public ProductRequest(final String refNo, final Condition condition, final String description) {
        this.refNo = refNo;
        this.condition = condition;
        this.description = description;
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
}
