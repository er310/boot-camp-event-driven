package com.tw.backend.controller;

import com.tw.backend.service.command.CostumeService;
import com.tw.library.dto.CostumeDto;
import com.tw.library.data.Result;
import com.tw.library.model.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/costumes")
public class CostumeController {
    private CostumeService service;

    @Autowired
    public CostumeController(CostumeService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Result<List<CostumeDto>> getAll() {
        return new Result<>(Arrays.asList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Result<CostumeDto> getById(@PathVariable Long id) {
        return new Result<>(new CostumeDto("AC009", Condition.NEW));
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Result<CostumeDto> create(@RequestBody CostumeDto dto) {
        return this.service.sendMessage(dto);
    }
}