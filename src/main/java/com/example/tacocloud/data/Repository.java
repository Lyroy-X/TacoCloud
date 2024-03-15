package com.example.tacocloud.data;

public interface Repository<T> extends RepositoryForFindAll<T>, RepositoryForSave<T>, RepositoryForFindById<T> {
}