package com.example.restaurantB.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${service.a.base-url}")
    private String baseUrl;

    public List<Map<String, Object>> getMenu() {
        String url = baseUrl + "/menu";
        Map<String, Object>[] menuArray = restTemplate.getForObject(url, Map[].class);
        return Arrays.asList(menuArray);
    }

    public Map<String, Object> calculatePrice(List<String> dishNames) {
        String url = baseUrl + "/calculate-price";
        Map<String, Object> request = new HashMap<>();
        request.put("dishes", dishNames);
        return restTemplate.postForObject(url, request, Map.class);
    }
}
