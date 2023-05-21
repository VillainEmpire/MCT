package com.geekster.foodDeliverySystem.service;

import com.geekster.foodDeliverySystem.model.FoodItem;
import com.geekster.foodDeliverySystem.model.FoodOrder;
import com.geekster.foodDeliverySystem.model.User;
import com.geekster.foodDeliverySystem.repository.FoodOrderRepository;
import com.geekster.foodDeliverySystem.repository.FoodItemRepository;
import com.geekster.foodDeliverySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOrderService {
    @Autowired
    FoodOrderRepository iFoodOrderRepository;

    @Autowired
    UserRepository iUserRepository;

    @Autowired
    FoodItemRepository foodItemRepository;

    public FoodOrder createOrder(FoodOrder foodOrder) {

        User user = iUserRepository.findByUserId(foodOrder.getUser().getUserId());
        foodOrder.setUser(user);
        FoodItem foodItem = foodItemRepository.findByFoodItemId(foodOrder.getFoodItem().getFoodItemId());
        foodOrder.setFoodItem(foodItem);

        return iFoodOrderRepository.save(foodOrder);
    }

    public FoodOrder getOrderById(Long orderId) {
        return iFoodOrderRepository.findByFoodOrderId(orderId);
    }

    public List<FoodOrder> getAllOrders() {
        return iFoodOrderRepository.findAll();
    }
}

