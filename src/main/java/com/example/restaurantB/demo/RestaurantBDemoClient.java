// For running Java demo client

package com.example.restaurantB.demo;

import com.example.restaurantB.model.OrderItem;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class RestaurantBDemoClient {

    public static void main(String[] args) {
        System.out.println("=== DEMO: Service B calling Service A ===\n");

        RestTemplate restTemplate = new RestTemplate();

  
        String menuUrl = "http://localhost:8080/menu";
        ResponseEntity<String> menuResponse = restTemplate.getForEntity(menuUrl, String.class);
        System.out.println("[From Service A] Menu:");
        System.out.println("→ " + menuResponse.getBody() + "\n");

   
        String calcUrl = "http://localhost:8080/calculate-price";
        List<OrderItem> order = List.of(
                new OrderItem("ข้าวผัด", 2),
                new OrderItem("หมูกรอบคั่วพริกเกลือ", 1)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<OrderItem>> request = new HttpEntity<>(order, headers);

        Map<String, Object> response = restTemplate.postForObject(calcUrl, request, Map.class);

        System.out.println("[From Service A] Calculated total price:");
        System.out.println("→ Ordered items:");
        order.forEach(item -> System.out.println("   - " + item.getName() + " x " + item.getQuantity()));
        System.out.println("→ Total price: " + response.get("totalPrice") + " THB");
    }
}
