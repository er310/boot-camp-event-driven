package com.tw.library.dto;

import com.tw.library.model.Condition;

import java.io.Serializable;

public class CostumeDto implements Serializable {

    protected final String costumeId;
    protected final Condition condition;

    public CostumeDto(final String costumeId, final Condition condition) {
        this.costumeId = costumeId;
        this.condition = condition;
    }

    public String getCostumeId() {
        return this.costumeId;
    }

    public Condition getCondition() {
        return this.condition;
    }
}
