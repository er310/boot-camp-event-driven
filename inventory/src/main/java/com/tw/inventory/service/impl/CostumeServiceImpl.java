package com.tw.inventory.service.impl;

import com.tw.inventory.entity.Costume;
import com.tw.inventory.repository.CostumeRepository;
import com.tw.inventory.service.AbstractService;
import com.tw.inventory.service.CostumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CostumeServiceImpl extends AbstractService<Costume, Long> implements CostumeService {

    protected final CostumeRepository repository;

    @Autowired
    public CostumeServiceImpl(CostumeRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Costume, Long> getRepository() {
        return repository;
    }

    @Override
    public Costume create(Costume costume) {
        return repository.save(costume);
    }
}