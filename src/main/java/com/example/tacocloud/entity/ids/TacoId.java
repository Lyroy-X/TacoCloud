package com.example.tacocloud.entity.ids;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TacoId implements Serializable {

    @Size(min = 5, message = "Количечство симвоолов не превышает минимум (5)")
    private String name;

    private Date createdAt;

    public TacoId() {
        this.createdAt =  new Date();
    }
}
