package com.example.restaurantB.demo;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestaurantBDemoClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String menuUrl = "http://192.168.1.83:8080/menu";
        String menu = restTemplate.getForObject(menuUrl, String.class);
        System.out.println("Menu from A: " + menu);

        
        String waitTimeUrl = "http://192.168.1.83:8080/wait-time";
        Map<String, Integer> request = new HashMap<>();
        request.put("dishes", 4); 
        Map<String, Object> waitTime = restTemplate.postForObject(waitTimeUrl, request, Map.class);
        System.out.println("Estimated wait time from A: " + waitTime);
    }
}
