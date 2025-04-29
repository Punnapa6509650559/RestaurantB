package com.example.restaurantB.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EstimateWaitTimeService {

    public Map<String, Object> estimateWaitTime(int dishes) {
        int waitTime = dishes * 12; // สมมุติ logic: 12 นาทีต่อจาน
        Map<String, Object> response = new HashMap<>();
        response.put("waitTime", waitTime);
        return response;
    }
}
