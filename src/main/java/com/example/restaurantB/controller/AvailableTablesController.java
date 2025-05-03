package com.example.restaurantB.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailableTablesController {

    private final JdbcTemplate jdbcTemplate;

    public AvailableTablesController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/available-tables")
    public int getAvailableTables() {
        Integer count = jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM table_status WHERE is_available = TRUE", Integer.class);
        return count != null ? count : 0;
    }
}
