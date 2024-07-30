package com.example.demo.service;

import java.util.List;

import com.example.demo.model.IngredientCategory;
import com.example.demo.model.IngredientsItem;

public interface IngredientService {

    public IngredientCategory createIngredientCategory(String name ,Long restaurantId) throws Exception;

    public IngredientCategory findIngredientCategoryById (Long id) throws Exception;

    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;

    public IngredientsItem createIngredientsItem(long restaurantId, String ingredientName, Long categoryId) throws Exception;

    public IngredientsItem updateStock(long id) throws Exception;

    public List<IngredientsItem> findRestaurantsIngredients (long restaurantId);
}