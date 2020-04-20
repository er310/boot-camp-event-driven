package com.tw.backend.service.command;

import com.tw.backend.dto.Costume;
import com.tw.library.data.Result;

public interface CostumeService {
    Result<Costume> sendMessage(Costume costume);
}
