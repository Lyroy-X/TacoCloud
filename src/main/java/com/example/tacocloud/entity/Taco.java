package com.example.tacocloud.entity;

import com.example.tacocloud.entity.ids.TacoId;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Taco {

    @Valid
    @EmbeddedId
    private TacoId tacoId;

    @NotNull
    @Size(min = 1, message = "Нужен хотя бы один ингридиент")
    @ManyToMany
    @JoinTable(name = "taco_ingredients",
            joinColumns = {@JoinColumn(name = "taco_created_at"), @JoinColumn(name = "taco_name")},
            inverseJoinColumns = @JoinColumn(name = "ingredient_name")
    )
    private List<Ingredient> ingredients;

    @ManyToOne
    private TacoOrder tacoOrder;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "Taco{" +
                "tacoId=" + tacoId +
                ", ingredients=" + ingredients +
                '}';
    }
}