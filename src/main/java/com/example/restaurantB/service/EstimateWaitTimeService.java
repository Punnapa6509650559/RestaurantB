package com.example.restaurantB.service;

import com.example.restaurantB.model.OrderItem;
import com.example.restaurantB.model.WaitTime;
import com.example.restaurantB.repository.WaitTimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EstimateWaitTimeService {

    private final WaitTimeRepository waitTimeRepository;

    public EstimateWaitTimeService(WaitTimeRepository waitTimeRepository) {
        this.waitTimeRepository = waitTimeRepository;
    }

    public int estimateWaitTime(List<OrderItem> order) {
        int total = 0;

        for (OrderItem item : order) {
            WaitTime wt = waitTimeRepository.findByName(item.getName()).orElse(null);
            int base = (wt != null) ? wt.getMinutes() : 10;
            int qty = item.getQuantity();

            if (qty == 1) {
                total += base;
            } else {
                total += base + (int) ((qty - 1) * base * 0.5);
            }
        }

        return total;
    }
}
