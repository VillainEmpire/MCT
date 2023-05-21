package com.geekster.foodDeliverySystem.repository;


import com.geekster.foodDeliverySystem.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
    FoodOrder findByFoodOrderId(Long orderId);
}
