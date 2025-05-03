package com.example.restaurantB.demo;

import org.springframework.web.client.RestTemplate;

public class AvailableTablesClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/available-tables";

        try {
            Integer available = restTemplate.getForObject(url, Integer.class);
            System.out.println("=== Available Tables ===");
            System.out.println("Currently available tables: " + available);
        } catch (Exception e) {
            System.out.println("Error calling /available-tables: " + e.getMessage());
        }
    }
}
