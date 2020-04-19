package com.tw.inventory.service;

import com.tw.inventory.entity.Costume;

public interface CostumeService extends BaseService<Costume, Long> {
    Costume create(Costume costume);
}