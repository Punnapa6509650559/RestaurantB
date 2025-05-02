package com.example.restaurantB.controller;

import com.example.restaurantB.model.OrderItem;
import com.example.restaurantB.service.EstimateWaitTimeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EstimateWaitTimeController {

    private final EstimateWaitTimeService service;

    public EstimateWaitTimeController(EstimateWaitTimeService service) {
        this.service = service;
    }

    @PostMapping("/api/estimate-wait-time")
    public Map<String, Object> estimate(@RequestBody Map<String, List<OrderItem>> body) {
        List<OrderItem> order = body.get("order");
        int waitTime = service.estimateWaitTime(order);
    
        Map<String, Object> response = new HashMap<>();
        response.put("waitTime", waitTime);
        return response;
    }
}    

