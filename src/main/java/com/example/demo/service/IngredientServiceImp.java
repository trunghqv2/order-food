package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IngredientCategory;
import com.example.demo.model.IngredientsItem;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.IngredientCategoriRepository;
import com.example.demo.repository.IngredientItemRepository;

@Service
public class IngredientServiceImp implements IngredientService {

    @Autowired
    private IngredientItemRepository ingredientItemRepository;

    @Autowired
    private IngredientCategoriRepository ingredientCategoriRepository;

    @Autowired
    private RestaurantService restaurantSevice;

    @Override
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
    Restaurant restaurant =restaurantSevice.findRestaurantById(restaurantId);
    IngredientCategory category = new IngredientCategory(); 
    category.setRestaurant(restaurant);
    category.setName(name);

    return ingredientCategoriRepository.save(category);
        
    }

    @Override
    public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
        Optional<IngredientCategory>opt = Optional.empty();
        if(opt.isEmpty()){
            throw new Exception("Ingredient Categori not fount");
        }
        return opt.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
        restaurantSevice.findRestaurantById(id);
        return ingredientCategoriRepository.findByRestaurantId(id);
    }

    @Override
    public IngredientsItem createIngredientsItem(long restaurantId, String ingredientName, Long categoryId)
            throws Exception {
      IngredientCategory category=findIngredientCategoryById(categoryId);
                Restaurant restaurant = restaurantSevice.findRestaurantById(restaurantId);
      IngredientsItem item = new IngredientsItem();
      item.setName(ingredientName);
      item.setRestaurant(restaurant);
      item.setCategory(category);
      IngredientsItem ingredient = ingredientItemRepository.save(item);
      category.getIngredients().add(ingredient);

      return ingredient;

    }

    @Override
    public IngredientsItem updateStock(long id) throws Exception {
       Optional<IngredientsItem> optIngredientsItem = ingredientItemRepository.findById(id);
        if(optIngredientsItem.isEmpty()){
            throw new Exception("Ingredient not found");
        }
        IngredientsItem ingredientsItem = (IngredientsItem) optIngredientsItem.get();
        ingredientsItem.setInStoke(ingredientsItem.isInStoke());
        return ingredientItemRepository.save(ingredientsItem);
    }

    @Override
    public List<IngredientsItem> findRestaurantsIngredients(long restaurantId) {
       return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

}
