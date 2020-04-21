package com.tw.backend.service.command;

import com.tw.library.data.Result;
import com.tw.library.dto.CostumeDto;

public interface CostumeService {
    Result<CostumeDto> sendMessage(CostumeDto costume);
}
