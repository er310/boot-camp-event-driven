package com.tw.inventory.repository;

import com.tw.inventory.entity.Costume;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CostumeRepository extends MongoRepository<Costume, Long> {
}