package com.example.tacocloud.data;

import com.example.tacocloud.*;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
public class OrderRepository implements RepositoryForSave<TacoOrder> {

    private final JdbcOperations jdbcTemplate;
    private int idOrder;

    public OrderRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        idOrder = 1;
    }

    @Override
    @Transactional
    public void save(TacoOrder tacoOrder) {
        tacoOrder.setPlaceAt(new Date());
        tacoOrder.setId(idOrder);

        CC cc = tacoOrder.getCc();
        saveCC(cc);

        DeliveryAddress deliveryAddress = tacoOrder.getDeliveryAddress();
        saveAddress(deliveryAddress);

        jdbcTemplate.update("INSERT INTO taco_order(id, id_cc, id_address, placeat) VALUES (?, ?, ?, ?)",
                idOrder,
                cc.getId(),
                deliveryAddress.getId(),
                tacoOrder.getPlaceAt()
        );

        List<Taco> tacos = tacoOrder.getTacos();
        int idTacoTemplate = 1;

        for (Taco taco : tacos)
            saveTaco(taco, idTacoTemplate++);

        idOrder++;
    }

    private void saveAddress(DeliveryAddress deliveryAddress) {
        deliveryAddress.setId(idOrder);
        jdbcTemplate.update("INSERT INTO address(id, name, street, city, state, zip) VALUES (?, ?, ?, ?, ?, ?)",
                deliveryAddress.getId(),
                deliveryAddress.getName(),
                deliveryAddress.getStreet(),
                deliveryAddress.getCity(),
                deliveryAddress.getState(),
                deliveryAddress.getZip()
        );
    }

    private void saveCC(CC cc) {
        cc.setId(idOrder);
        jdbcTemplate.update("INSERT INTO cc(id, number, expiration, cvv) VALUES (?, ?, ?, ?)",
                cc.getId(),
                cc.getNumber(),
                cc.getExpiration(),
                cc.getCvv()
        );
    }

    private void saveTaco(Taco taco, int idTaco) {
        taco.setCreatedAt(new Date());
        taco.setId(idTaco);

        jdbcTemplate.update("INSERT INTO taco(id, id_taco_order, name, createdat) VALUES (?, ?, ?, ?)",
                idTaco,
                idOrder,
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