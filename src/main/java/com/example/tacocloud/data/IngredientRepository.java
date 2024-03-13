package com.example.tacocloud.data;

import com.example.tacocloud.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class IngredientRepository implements Repository<Ingredient> {

    private JdbcTemplate jdbcTemplate;

    public IngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(Ingredient ingredient) {

    }

    private Ingredient convert(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(
                row.getInt(1),
                row.getString(2),
                Ingredient.Type.valueOf(row.getString(3))
        );
    }
}
