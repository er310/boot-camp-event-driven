package com.tw.library.amazon;

import com.tw.library.model.Condition;
import com.tw.library.model.SellStatus;

import java.time.ZonedDateTime;

public class ProductWebHook {
    protected final String refNo;
    protected final SellStatus status;

    public ProductWebHook(final String refNo, final SellStatus status) {
        this.refNo = refNo;
        this.status = status;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public SellStatus getStatus() {
        return this.status;
    }
}
