package com.example.tacocloud;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder {

    @NotNull
    private Long id;

    @NotNull
    private Date placeAt;

    @Valid
    private DeliveryAddress deliveryAddress;

    @Valid
    private CC cc;

    private List<Taco> tacos;

    public TacoOrder() {
        this.deliveryAddress = new DeliveryAddress();
        this.cc = new CC();
        this.tacos = new ArrayList<>();
    }

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

    public String getName() {
        return deliveryAddress.getName();
    }

    public void setName(String name) {
        deliveryAddress.setName(name);
    }

    public String getCity() {
        return deliveryAddress.getCity();
    }

    public void setCity(String city) {
        deliveryAddress.setCity(city);
    }

    public String getStreet() {
        return deliveryAddress.getStreet();
    }

    public void setStreet(String street) {
        deliveryAddress.setStreet(street);
    }

    public String getState() {
        return deliveryAddress.getState();
    }

    public void setState(String state) {
        deliveryAddress.setState(state);
    }

    public String getZip() {
        return deliveryAddress.getZip();
    }

    public void setZip(String zip) {
        deliveryAddress.setZip(zip);
    }

    public String getNumber() {
        return cc.getNumber();
    }

    public String getExpiration() {
        return cc.getExpiration();
    }

    public String getCvv() {
        return cc.getCvv();
    }

    public void setNumber(String number) {
        cc.setNumber(number);
    }

    public void setExpiration(String expiration) {
        cc.setExpiration(expiration);
    }

    public void setCvv(String cvv) {
        cc.setCvv(cvv);
    }
}