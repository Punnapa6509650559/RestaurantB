package com.example.restaurantB.controller;

import com.example.restaurantB.service.AvailableTablesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AvailableTablesController {

    private final AvailableTablesService service;

    public AvailableTablesController(AvailableTablesService service) {
        this.service = service;
    }

    @GetMapping("/api/available-tables")
    public Map<String, Object> getAvailableTables() {
        return service.getAvailableTables();
    }
}
