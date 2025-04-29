package com.example.restaurantB.controller;

import com.example.restaurantB.service.AvailableTablesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AvailableTablesController {

    private final AvailableTablesService availableTablesService;

    public AvailableTablesController(AvailableTablesService availableTablesService) {
        this.availableTablesService = availableTablesService;
    }

    @GetMapping("/api/available-tables")
    public Map<String, Object> getAvailableTables() {
        return availableTablesService.getAvailableTables();
    }
}
