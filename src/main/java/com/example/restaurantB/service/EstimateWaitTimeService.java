package com.example.restaurantB.service;

import com.example.restaurantB.model.OrderItem;
import com.example.restaurantB.model.WaitTime;
import com.example.restaurantB.repository.WaitTimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstimateWaitTimeService {

    private final WaitTimeRepository waitTimeRepository;

    public EstimateWaitTimeService(WaitTimeRepository waitTimeRepository) {
        this.waitTimeRepository = waitTimeRepository;
    }

    public int estimateWaitTime(List<OrderItem> order) {
        int total = 0;

        for (OrderItem item : order) {
            String itemName = item.getName().trim(); // เผื่อกรณีมีช่องว่าง
            int quantity = item.getQuantity();

            // Debug log
            System.out.println("Looking up: \"" + itemName + "\" (quantity: " + quantity + ")");

            WaitTime wt = waitTimeRepository.findByName(itemName).orElse(null);
            if (wt != null) {
                System.out.println("Found in DB → base wait time: " + wt.getMinutes() + " mins");
            } else {
                System.out.println("NOT FOUND in DB → using fallback: 10 mins");
            }

            int base = (wt != null) ? wt.getMinutes() : 10;

            if (quantity == 1) {
                total += base;
            } else {
                total += base + (int) ((quantity - 1) * base * 0.5);
            }
        }

        return total;
    }
}
