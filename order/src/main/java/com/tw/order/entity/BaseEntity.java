package com.tw.order.entity;

public interface BaseEntity {
    void setId(Long id);

    Long getId();

    boolean getIsNew();

    void setName(String name);

    String getName();
}