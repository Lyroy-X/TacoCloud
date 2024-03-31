package com.example.tacocloud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.CreditCardNumber;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class CC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreditCardNumber(message = "*Не действительный номер карты")
    private String number;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/(\\d{2})$", message = "*Не верный формат даты")
    private String expiration;

    @Digits(integer = 3, message = "*Не верный CVV", fraction = 0)
    private String cvv;
}