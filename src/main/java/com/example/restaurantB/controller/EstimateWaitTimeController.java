package com.example.restaurantB.controller;

import com.example.restaurantB.service.EstimateWaitTimeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EstimateWaitTimeController {

    private final EstimateWaitTimeService service;

    public EstimateWaitTimeController(EstimateWaitTimeService service) {
        this.service = service;
    }

    @PostMapping("/api/estimate-wait-time")
    public Map<String, Object> estimate(@RequestBody Map<String, Integer> body) {
        int dishes = body.getOrDefault("dishes", 1);
        return service.estimateWaitTime(dishes);
    }
}
