package com.geekster.foodDeliverySystem.repository;

import com.geekster.foodDeliverySystem.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByToken(String token);

}

