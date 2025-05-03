package com.example.restaurantB.demo;

import com.example.restaurantB.model.OrderItem;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestaurantBDemoClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

     
        String aMenuUrl = "http://localhost:8080/menu";
        ResponseEntity<String> menuResponse = restTemplate.getForEntity(aMenuUrl, String.class);
        System.out.println("Menu from A:");
        System.out.println(menuResponse.getBody());

        String calcUrl = "http://localhost:8080/calculate-price";
        List<OrderItem> order = List.of(
                new OrderItem("ข้าวผัด", 2),
                new OrderItem("หมูกรอบคั่วพริกเกลือ", 1)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<OrderItem>> request = new HttpEntity<>(order, headers);

        Integer price = restTemplate.postForObject(calcUrl, request, Integer.class);
        System.out.println("Total price from A: " + price + " THB");
    }
}
