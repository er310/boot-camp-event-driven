package com.tw.inventory.service;

import com.tw.inventory.entity.Costume;
import com.tw.library.data.Result;
import com.tw.library.dto.CostumeDto;

public interface CostumeService extends BaseService<Costume, Long> {
    Result<CostumeDto> create(CostumeDto dto);
}