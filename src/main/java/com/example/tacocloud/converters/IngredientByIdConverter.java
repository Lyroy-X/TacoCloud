package com.example.tacocloud.converters;

import com.example.tacocloud.Ingredient;
import com.example.tacocloud.data.Repository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final Repository<Ingredient> ingredientRepository;

    @Autowired
    public IngredientByIdConverter(Repository<Ingredient> ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(@NonNull String id) {
        return ingredientRepository.findById(Integer.parseInt(id)).orElseThrow();
    }
}