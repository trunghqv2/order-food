package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;
import com.example.demo.request.CreateFoodRequest;

public interface FoodService {
    public Food createFood(CreateFoodRequest req , Category category ,Restaurant restaurant);

    void deletedFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(long restaurantId ,boolean isVegitarain,boolean isNonveg, boolean isSeasonal,String foodCategory);

    public List<Food>searchFood(String keyword);
    
    public Food findFoodById(Long foodId) throws Exception;

    public Food updateAvailibiityStatus(Long foodId) throws Exception;
}
