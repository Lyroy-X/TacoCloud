package com.example.tacocloud.data;

import com.example.tacocloud.*;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
public class OrderRepositoryDeprecated implements RepositoryForSave<TacoOrder> {

    private final JdbcOperations jdbcTemplate;
    private int orderId;
    private int tacoId;

    public OrderRepositoryDeprecated(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        orderId = tacoId = 1;
    }

    @Override
    @Transactional
    public void save(TacoOrder tacoOrder) {
        tacoOrder.setPlaceAt(new Date());
        tacoOrder.setId(orderId);

        CC cc = tacoOrder.getCc();
        saveCC(cc);

        DeliveryAddress deliveryAddress = tacoOrder.getDeliveryAddress();
        saveAddress(deliveryAddress);

        jdbcTemplate.update("INSERT INTO taco_order(id, id_cc, id_address, placeat) VALUES (?, ?, ?, ?)",
                orderId,
                cc.getId(),
                deliveryAddress.getId(),
                tacoOrder.getPlaceAt()
        );

        List<Taco> tacos = tacoOrder.getTacos();
        for (Taco taco : tacos) {
            saveTaco(taco);
            tacoId++;
        }
        orderId++;
    }

    private void saveAddress(DeliveryAddress deliveryAddress) {
        deliveryAddress.setId(orderId);
        jdbcTemplate.update("INSERT INTO address(id, name, street, city, state, zip) VALUES (?, ?, ?, ?, ?, ?)",
                deliveryAddress.getId(),
                deliveryAddress.getNameOfRecipient(),
                deliveryAddress.getStreet(),
                deliveryAddress.getCity(),
                deliveryAddress.getState(),
                deliveryAddress.getZip()
        );
    }

    private void saveCC(CC cc) {
        cc.setId(orderId);
        jdbcTemplate.update("INSERT INTO cc(id, number, expiration, cvv) VALUES (?, ?, ?, ?)",
                cc.getId(),
                cc.getNumber(),
                cc.getExpiration(),
                cc.getCvv()
        );
    }

    private void saveTaco(Taco taco) {
        taco.setCreatedAt(new Date());
        taco.setId(tacoId);

        jdbcTemplate.update("INSERT INTO taco(id, id_taco_order, name, createdat) VALUES (?, ?, ?, ?)",
                tacoId,
                orderId,
                taco.getName(),
                taco.getCreatedAt()
        );

        saveTacoIngredients(taco);
    }

    private void saveTacoIngredients(Taco taco) {
        List<Ingredient> ingredients = taco.getIngredients();
        int tacoId = taco.getId();

        for (Ingredient ingredient : ingredients)
            saveIngredient(tacoId, ingredient.getId());
    }

    private void saveIngredient(int tacoId, int ingredientId) {
        jdbcTemplate.update("INSERT INTO ingredient_ref(id_taco, id_ingredient) VALUES (?, ?)", tacoId, ingredientId);
    }
}