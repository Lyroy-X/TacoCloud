package com.example.tacocloud;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
public class CC {

    @CreditCardNumber(message = "*Не действительный номер карты")
    private String number;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/(\\d{2})$", message = "*Не верный формат даты")
    private String expiration;

    @Digits(integer = 3, message = "*Не верный CVV", fraction = 0)
    private String cvv;
}

