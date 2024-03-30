package com.example.tacocloud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "address")
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotBlank(message = "*Name обязательное поле")
    private String nameOfRecipient;

    @NotBlank(message = "*Street обязательное поле")
    private String street;

    @NotBlank(message = "*City обязательное поле")
    private String city;

    @NotBlank(message = "*State обязательное поле")
    private String state;

    @NotBlank(message = "*Zip обязательное поле")
    private String zip;
}
