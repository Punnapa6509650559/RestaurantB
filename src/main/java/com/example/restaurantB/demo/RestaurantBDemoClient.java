package com.example.restaurantB.demo;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantBDemoClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = "http://192.168.1.83:8080"; // URL ของ restaurantA

        // เรียกดูเมนูจาก A
        String menuUrl = baseUrl + "/menu";
        Map<String, Object>[] menuArray = restTemplate.getForObject(menuUrl, Map[].class);
        System.out.println("เมนูจากร้าน A:");
        if (menuArray != null) {
            for (Map<String, Object> item : menuArray) {
                System.out.println("- " + item.get("name") + " ราคา " + item.get("price") + " บาท");
            }
        }

        // ประเมินราคารวมจากชื่อเมนูที่เลือก
        String calculateUrl = baseUrl + "/calculate-price";

        List<String> selectedDishes = Arrays.asList(
                "ข้าวผัด",
                "หมูกรอบคั่วพริกเกลือ",
                "กะเพราหมูสับไข่ดาว"
        );

        Map<String, Object> request = new HashMap<>();
        request.put("dishes", selectedDishes);

        Map<String, Object> response = restTemplate.postForObject(calculateUrl, request, Map.class);
        System.out.println("\nรวมราคาทั้งหมด: " + response.get("totalPrice") + " บาท");
    }
}
