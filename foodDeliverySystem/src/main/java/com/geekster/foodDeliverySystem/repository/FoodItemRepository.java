package com.geekster.foodDeliverySystem.repository;

import com.geekster.foodDeliverySystem.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    FoodItem findByFoodItemId(Long foodItemId);
}
