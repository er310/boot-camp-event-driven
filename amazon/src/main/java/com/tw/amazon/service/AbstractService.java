package com.tw.amazon.service;

import com.tw.library.exception.ErrorCode;
import com.tw.library.exception.RecordNotFoundException;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, Id> implements BaseService<T, Id> {
    protected abstract CrudRepository<T, Id> getRepository();

    @Override
    public T getById(Id id) {
        Optional<T> aTable = getRepository().findById(id);

        return aTable
                .orElseThrow(() -> new RecordNotFoundException("Cannot find entity by id:" + id, ErrorCode.OBJECT_NOT_FOUND));
    }

    @Override
    public List<T> getAll() {
        return (List<T>) getRepository().findAll();
    }
}