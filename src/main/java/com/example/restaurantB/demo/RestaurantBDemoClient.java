package com.example.restaurantB.demo;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantBDemoClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://localhost:8080";

        // Fetch menu from A
        String menuUrl = baseUrl + "/menu";
        Map<String, Object>[] menuArray = restTemplate.getForObject(menuUrl, Map[].class);
        System.out.println("Menu from Restaurant A:");
        for (Map<String, Object> item : menuArray) {
            System.out.println("- " + item.get("name") + ": " + item.get("price") + " THB");
        }

        // Calculate price from A
        String calcUrl = baseUrl + "/calculate-price";
        List<String> selectedDishes = Arrays.asList("ข้าวผัด", "ไก่ย่าง");

        Map<String, Object> request = new HashMap<>();
        request.put("dishes", selectedDishes);

        Map<String, Object> priceResult = restTemplate.postForObject(calcUrl, request, Map.class);
        System.out.println("Total price: " + priceResult.get("totalPrice") + " THB");
    }
}
