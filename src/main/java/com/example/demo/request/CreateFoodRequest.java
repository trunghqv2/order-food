package com.example.demo.request;
import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.IngredientsItem;

import lombok.Data;

@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String> images;
    private Long restaurantId;
    private boolean vegetarin;
    private boolean seasonal;
    private List<IngredientsItem> ingredientsitems;
}
