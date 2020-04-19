package com.tw.inventory.entity;

import java.util.UUID;

public interface BaseEntity {
    void setId(UUID id);

    UUID getId();

    boolean getIsNew();

    void setName(String name);

    String getName();
}