package com.geekster.foodDeliverySystem.service;

import com.geekster.foodDeliverySystem.model.FoodItem;
import com.geekster.foodDeliverySystem.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;


    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public FoodItem getFoodItemById(Long id) {
        return foodItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Food item not found"));
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }

    public boolean addFoodItem(FoodItem foodItem) {
        foodItemRepository.save(foodItem);
        return true;
    }
}

