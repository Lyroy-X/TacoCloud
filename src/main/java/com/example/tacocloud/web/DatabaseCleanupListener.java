package com.example.tacocloud.web;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCleanupListener {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseCleanupListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void handleContextClosedEvent(ContextClosedEvent event) {
        String sqlStatementForCleaningAllTablesExceptTableIngredient = "DELETE FROM address; DELETE FROM cc;";
        jdbcTemplate.update(sqlStatementForCleaningAllTablesExceptTableIngredient);
    }
}
