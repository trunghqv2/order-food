package com.example.demo.service;


import java.util.List;

import com.example.demo.model.Category;

public interface CategorySevice {
    public Category createCategory(String name , Long userId)throws Exception;
    public List<Category> findCategoryByRestaurantId(Long id ) throws Exception;
    public Category findCategoryById(long id) throws Exception;
}