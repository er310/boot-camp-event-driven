package com.tw.inventory.service;

import java.util.List;

public interface BaseService<T, Id> {
    T getById(Id id);

    List<T> getAll();
}