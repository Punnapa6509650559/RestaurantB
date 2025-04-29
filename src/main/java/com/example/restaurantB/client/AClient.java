package com.example.restaurantB.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class AClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${service.a.base-url}")
    private String baseUrl;

    public String getMenu() {
        String url = baseUrl + "/menu";
        return restTemplate.getForObject(url, String.class);
    }

    public Map<String, Object> estimateWaitTime(int dishes) {
        String url = baseUrl + "/wait-time";
        Map<String, Integer> request = new HashMap<>();
        request.put("dishes", dishes);
        return restTemplate.postForObject(url, request, Map.class);
    }
}
