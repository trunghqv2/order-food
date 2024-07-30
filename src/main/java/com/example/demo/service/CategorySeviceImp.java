package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategorySeviceImp implements CategorySevice {

    @Autowired
    public RestaurantService restaurantSevice;

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {
        Restaurant restaurant = restaurantSevice.getRestaurantByUserId(userId);
        Category category = new Category();
        category.setName(name);
        category.setRestaurant(restaurant);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByRestaurantId(Long id) throws Exception {
        Restaurant restaurant = restaurantSevice.getRestaurantByUserId(id);
        return categoryRepository.findByRestaurantId(restaurant.getId());
    }

    @Override
    public Category findCategoryById(long id) throws Exception {
       Optional<Category> optionalCategory = categoryRepository.findById(id);
       if(optionalCategory.isEmpty()){
            throw new  Exception("Category not found..");
       }
       return optionalCategory.get();
    }

}
