package com.example.restaurantB.repository;

import com.example.restaurantB.model.WaitTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaitTimeRepository extends JpaRepository<WaitTime, Long> {
    Optional<WaitTime> findByName(String name);
}
