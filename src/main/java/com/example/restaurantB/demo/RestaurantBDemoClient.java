package com.example.restaurantB.demo;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class RestaurantBDemoClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("=== Restaurant B calling services from A ===\n");

       
        System.out.println("[Service 1] Get Menu");
        String menuUrl = "http://localhost:8080/menu";
        List<Map<String, Object>> menu = restTemplate.getForObject(menuUrl, List.class);

        System.out.println("Menu received from Restaurant A:");
        for (Map<String, Object> item : menu) {
            System.out.println("- " + item.get("name") + ": " + item.get("price") + " THB");
        }

        System.out.println("\n[Service 2] Calculate Price");
        String calcUrl = "http://localhost:8080/calculate-price";

        Map<String, Object> dish1 = new HashMap<>();
        dish1.put("name", "ข้าวผัด");
        dish1.put("quantity", 1);

        Map<String, Object> dish2 = new HashMap<>();
        dish2.put("name", "ไก่ย่าง");
        dish2.put("quantity", 2);

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("order", List.of(dish1, dish2));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(reqBody, headers);

        Map<String, Object> result = restTemplate.postForObject(calcUrl, entity, Map.class);
        System.out.println("Total price for selected items: " + result.get("totalPrice") + " THB");
    }
}
