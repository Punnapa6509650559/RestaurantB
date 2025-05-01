package com.example.restaurantB.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AvailableTablesService {

    public Map<String, Object> getAvailableTables() {
        Map<String, Object> response = new HashMap<>();
        response.put("availableTables", 5);
        return response;
    }
}
