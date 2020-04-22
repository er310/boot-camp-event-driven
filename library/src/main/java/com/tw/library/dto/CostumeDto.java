package com.tw.library.dto;

import com.tw.library.model.Condition;

import java.io.Serializable;

public class CostumeDto implements Serializable {

    protected final String costumeId;
    protected final String name;
    protected final Condition condition;

    public CostumeDto(final String name, final String costumeId, final Condition condition) {
        this.name = name;
        this.costumeId = costumeId;
        this.condition = condition;
    }

    public String getCostumeId() {
        return this.costumeId;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "CostumeDto{" +
                "costumeId='" + costumeId + '\'' +
                ", name='" + name + '\'' +
                ", condition=" + condition +
                '}';
    }
}
