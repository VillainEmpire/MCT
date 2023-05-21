package com.geekster.foodDeliverySystem.repository;

import com.geekster.foodDeliverySystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User, Long> {
}

