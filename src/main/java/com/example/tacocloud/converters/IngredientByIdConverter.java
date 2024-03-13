package com.example.tacocloud.converters;

import com.example.tacocloud.Ingredient;
import com.example.tacocloud.Ingredient.Type;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<Integer, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put(0, new Ingredient(0, "Flour Tortilla", Type.WRAP));
        ingredientMap.put(1, new Ingredient(1, "Corn Tortilla", Type.WRAP));
        ingredientMap.put(2, new Ingredient(2, "Ground Beef", Type.PROTEIN));
        ingredientMap.put(3, new Ingredient(3, "Carnitas", Type.PROTEIN));
        ingredientMap.put(4, new Ingredient(4, "Diced Tomatoes", Type.VEGGIES));
        ingredientMap.put(5, new Ingredient(5, "Lettuce", Type.VEGGIES));
        ingredientMap.put(6, new Ingredient(6, "Cheddar", Type.CHEESE));
        ingredientMap.put(7, new Ingredient(7, "Monterrey Jack", Type.CHEESE));
        ingredientMap.put(8, new Ingredient(8, "Salsa", Type.SAUCE));
        ingredientMap.put(9, new Ingredient(9, "Sour Cream", Type.SAUCE));
        ingredientMap.put(10, new Ingredient(10, "Size", Type.SIZE));
    }

    @Override
    public Ingredient convert(@NonNull String id) {
        return ingredientMap.get(Integer.parseInt(id));
    }
}