package com.example.demo.request;

import java.util.List;

import lombok.Data;
@Data
public class AddCartItemRequest {
    private Long foodId;
    private int quantity;
    private List<String> ingredientsItem;
   
}
