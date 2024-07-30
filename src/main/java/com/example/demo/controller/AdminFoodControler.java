package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.request.CreateFoodRequest;
import com.example.demo.response.MessageResponse;
import com.example.demo.service.FoodService;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodControler {
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userSevice;

    @Autowired
    private RestaurantService restaurantSevice;

    @PostMapping("")
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantSevice.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req, req.getCategory(), restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        foodService.deletedFood(id);
        MessageResponse res = new MessageResponse();
        res.setMessage("Food Delete successfully");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvaibilitySatus(@PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        Food food = foodService.updateAvailibiityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
}
