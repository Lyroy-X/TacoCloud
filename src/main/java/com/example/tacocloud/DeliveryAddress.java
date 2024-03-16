package com.example.tacocloud;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeliveryAddress {

    private int id;

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
