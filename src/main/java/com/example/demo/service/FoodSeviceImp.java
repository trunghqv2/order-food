package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.FoodRepository;
import com.example.demo.request.CreateFoodRequest;

@Service
public class FoodSeviceImp implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
        Food food = new Food();
        food.setFoodCategory(category);
        food.setDescription(req.getDescription());
        food.setRestaurant(restaurant);
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngredientsItems(req.getIngredientsitems());
        food.setSeasonal(req.isSeasonal());
        food.setVegetarian(req.isVegetarin());
        food.setCreationDate(LocalDateTime.now());

        Food saveFood = foodRepository.save(food);
        restaurant.getFoods().add(saveFood);
        return saveFood;
    }

    @Override
    public void deletedFood(Long foodId) throws Exception {
       Food food = findFoodById(foodId);
       food.setRestaurant(null);
       foodRepository.save(food);
    }

    @Override
    public List<Food> getRestaurantsFood(long restaurantId, boolean isVegitarain, boolean isNonveg, boolean isSeasonal,
            String foodCategory) {
        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);
        if(isVegitarain){
            foods =filterByVegetarian(foods,isVegitarain);
        }if(isNonveg){
            foods =filterByNonveg(foods,isNonveg);
        }if(isSeasonal){
            foods =filterBySeasonal(foods,isSeasonal);
        }if(foodCategory!=null && !foodCategory.equals("")){
            foods = filterByCategory(foods , foodCategory);
        }
        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {
        return foods.stream().filter(food -> {
            if(food.getFoodCategory() != null ){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());
    }

    private List<Food> filterBySeasonal(List<Food> foods, boolean isSeasonal) {
        return foods.stream().filter(food -> food.isSeasonal()== isSeasonal).collect(Collectors.toList());
    }

    private List<Food> filterByNonveg(List<Food> foods, boolean isNonveg) {
        return foods.stream().filter(food -> food.isVegetarian()== false).collect(Collectors.toList());
    }

    private List<Food> filterByVegetarian(List<Food> foods, boolean isVegitarain) {
       return foods.stream().filter(food -> food.isVegetarian()== isVegitarain).collect(Collectors.toList());
    }

    @Override
    public List<Food> searchFood(String keyword) {
      return foodRepository.searchFood(keyword);
    }

    @Override
    public Food findFoodById(Long foodId) throws Exception {
        Optional<Food> optionalFood = foodRepository.findById(foodId);
        if(optionalFood.isEmpty()){
            throw new Exception("food not exist...");
        }
        return optionalFood.get();
    }

    @Override
    public Food updateAvailibiityStatus(Long foodId) throws Exception {
      Food food = findFoodById(foodId);
      food.setAvailable(!food.isAvailable());
      return foodRepository.save(food);
    }

}
