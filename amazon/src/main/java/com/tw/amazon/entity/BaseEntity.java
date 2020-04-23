package com.tw.amazon.entity;

public interface BaseEntity {
    void setId(String id);

    String getId();

    boolean getIsNew();

    void setName(String name);

    String getName();
}