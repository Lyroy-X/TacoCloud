package com.example.tacocloud.entity.ids;

import com.example.tacocloud.entity.Ingredient;
import com.example.tacocloud.entity.Taco;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class TacoIngredientId implements Serializable {

    @ManyToOne
    private Taco taco;

    @ManyToOne
    private Ingredient ingredient;
}
