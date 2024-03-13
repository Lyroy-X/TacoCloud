package com.example.tacocloud.data;

import com.example.tacocloud.Ingredient;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository<T> {

    List<T> findAll();

    Optional<T> findById(String id);

    void save(T t);
}
