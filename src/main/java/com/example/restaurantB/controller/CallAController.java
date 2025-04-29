package com.example.restaurantB.controller;

import com.example.restaurantB.client.AClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CallAController {

    private final AClient aClient;

    public CallAController(AClient aClient) {
        this.aClient = aClient;
    }

    @GetMapping("/call-a/menu")
    public String callMenuFromA() {
        return aClient.getMenu();
    }

    @PostMapping("/call-a/wait-time")
    public Map<String, Object> callWaitTimeFromA(@RequestBody Map<String, Integer> request) {
        return aClient.estimateWaitTime(request.getOrDefault("dishes", 1));
    }
}
