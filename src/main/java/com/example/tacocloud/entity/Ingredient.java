package com.example.tacocloud.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = "ingredients")
    private List<Taco> tacos;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE, SIZE
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}