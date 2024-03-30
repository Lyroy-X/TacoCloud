package com.example.tacocloud.entity;

import com.example.tacocloud.entity.ids.TacoIngredientId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TacoIngredients {

    @EmbeddedId
    private TacoIngredientId id;
}
