package com.example.restaurantB.service;

import com.example.restaurantB.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstimateWaitTimeService {

    private final Map<String, Integer> waitTimeMap = new HashMap<>();

    public EstimateWaitTimeService() {
        waitTimeMap.put("กะเพราหมูสับไข่ดาว", 12);
        waitTimeMap.put("หมูกรอบคั่วพริกเกลือ", 15);
        waitTimeMap.put("ไก่ย่าง", 10);
        waitTimeMap.put("ข้าวผัด", 10);
    }

    public int estimateWaitTime(List<OrderItem> order) {
        int totalWait = 0;

        for (OrderItem item : order) {
            int baseTime = waitTimeMap.getOrDefault(item.getName(), 10);
            int qty = item.getQuantity();

            if (qty == 1) {
                totalWait += baseTime;
            } else {
    
                totalWait += baseTime + (int) ((qty - 1) * baseTime * 0.5);
            }
        }

        return totalWait;
    }
}
