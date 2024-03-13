package com.example.tacocloud.data;

import com.example.tacocloud.Ingredient;

import java.util.List;
import java.util.Optional;

public class IngredientRepository implements Repository<Ingredient> {

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(Ingredient ingredient) {

    }
}
