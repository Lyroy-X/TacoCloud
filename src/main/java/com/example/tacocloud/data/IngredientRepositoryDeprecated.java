package com.example.tacocloud.data;

import com.example.tacocloud.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Repository
public class IngredientRepositoryDeprecated implements Repository<Ingredient> {


    private final JdbcTemplate jdbcTemplate;

    public IngredientRepositoryDeprecated(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ingredient> findAll() {
        return jdbcTemplate.query("SELECT id, name, type FROM ingredient;", this::convertRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(int id) {
        List<Ingredient> ingredients = jdbcTemplate.query("SELECT id, name, type FROM ingredient WHERE id = ?;", this::convertRowToIngredient, id);
        return ingredients.isEmpty() ? Optional.empty() : Optional.of(ingredients.get(0));
    }

    @Override
    public void save(Ingredient ingredient) {
        jdbcTemplate.update("INSERT INTO ingredient (id, name, type) VALUES (?, ?, ?);",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString()
        );
    }

    private Ingredient convertRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(
                row.getInt(1),
                row.getString(2),
                Ingredient.Type.valueOf(row.getString(3))
        );
    }
}
