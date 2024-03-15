package com.example.tacocloud.data;

import java.util.List;

public interface RepositoryForFindAll<T> {

    List<T> findAll();
}