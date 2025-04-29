package com.example.restaurantB.controller;

import com.example.restaurantB.service.EstimateWaitTimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EstimateWaitTimeController {

    private final EstimateWaitTimeService estimateWaitTimeService;

    public EstimateWaitTimeController(EstimateWaitTimeService estimateWaitTimeService) {
        this.estimateWaitTimeService = estimateWaitTimeService;
    }

    @PostMapping("/api/estimate-wait-time")
    public Map<String, Object> estimateWaitTime(@RequestBody Map<String, Integer> request) {
        return estimateWaitTimeService.estimateWaitTime(request.getOrDefault("dishes", 1));
    }
}
