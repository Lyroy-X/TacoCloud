package com.example.tacocloud.converters;

import com.example.tacocloud.entity.Ingredient;
import com.example.tacocloud.data.IngredientRepository;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(@NonNull String id) {
        return ingredientRepository.findById(id).orElseThrow();
    }
}