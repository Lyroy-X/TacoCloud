package com.example.tacocloud.entity;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "taco_order")
public class TacoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "place_at")
    private Date placeAt;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private DeliveryAddress deliveryAddress;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private CC cc;

    @OneToMany(mappedBy = "tacoOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Taco> tacos;

    public TacoOrder() {
        this.placeAt = new Date();
        this.deliveryAddress = new DeliveryAddress();
        this.cc = new CC();
        this.tacos = new ArrayList<>();
    }

    public void addTaco(Taco taco) {
        tacos.add(taco);
        taco.setTacoOrder(this);
    }
}