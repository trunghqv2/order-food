package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Food;
import com.example.demo.model.User;
import com.example.demo.service.FoodService;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/food")
public class FoodControler {
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userSevice;

    @Autowired
    private RestaurantService restaurantSevice;

    @PostMapping("/search")
    public ResponseEntity<List<Food>> sreachFood(@RequestParam String name,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        List<Food> foods = foodService.searchFood(name);
        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(@RequestParam boolean vagetarian,
            @RequestParam boolean seasonal,
            @RequestParam boolean nonveg, @RequestParam(required = false) String food_category,
            @RequestParam Long restaurantId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        List<Food> foods = foodService.getRestaurantsFood(restaurantId, vagetarian, nonveg, seasonal, food_category);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
}
