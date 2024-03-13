package com.example.tacocloud;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

    @NotNull
    private Long id;

    @NotNull
    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Количечство симвоолов не превышает минимум (5)")
    private String name;

    @NotNull
    @Size(min = 1, message = "Нужен хотя бы один ингридиент")
    private List<Ingredient> ingredients;
}
