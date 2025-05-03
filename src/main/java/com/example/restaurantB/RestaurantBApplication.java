package com.example.restaurantB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; 

@SpringBootApplication
@EntityScan("com.example.restaurantB.model")
public class RestaurantBApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantBApplication.class, args);
    }
}
