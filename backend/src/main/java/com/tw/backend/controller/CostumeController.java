package com.tw.backend.controller;

import com.tw.backend.dto.Costume;
import com.tw.backend.service.command.CostumeService;
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
    Result<List<Costume>> getAll() {
        return new Result<>(Arrays.asList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Result<Costume> getById(@PathVariable Long id) {
        return new Result<>(new Costume("AC009", Condition.NEW));
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Result<Costume> create(@RequestBody Costume costume) {
        return this.service.sendMessage(costume);
    }
}