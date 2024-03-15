package com.example.tacocloud.data;

import java.util.Optional;

public interface RepositoryForFindById<T> {

    Optional<T> findById(int id);
}