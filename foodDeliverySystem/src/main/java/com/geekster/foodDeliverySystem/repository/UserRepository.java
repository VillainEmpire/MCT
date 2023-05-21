package com.geekster.foodDeliverySystem.repository;

import com.geekster.foodDeliverySystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String userEmail);

    User findByUserId(Long userId);
}