package com.example.tacocloud.data;

public interface RepositoryForSave<T> {

    void save(T t);
}
