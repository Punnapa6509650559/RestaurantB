package com.example.restaurantB.controller;

import com.example.restaurantB.client.AClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/call-a")
public class CallAController {

    private final AClient aClient;

    public CallAController(AClient aClient) {
        this.aClient = aClient;
    }

    @GetMapping("/menu")
    public List<Map<String, Object>> callMenuFromA() {
        return aClient.getMenu();
    }

    @PostMapping("/calculate-price")
    public Map<String, Object> callCalculatePriceFromA(@RequestBody Map<String, List<String>> body) {
        List<String> dishes = body.get("dishes");
        return aClient.calculatePrice(dishes);
    }
}
