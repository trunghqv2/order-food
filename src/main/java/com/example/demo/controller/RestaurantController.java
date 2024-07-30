package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RestaurantDto;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private UserService userSevice;

    @Autowired
    private RestaurantService restaurantSevice;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword) throws Exception {

        User user = userSevice.findUserByJwtToken(jwt);
        List<Restaurant> restaurant = restaurantSevice.sreachRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Restaurant>> getAllRestaurant(
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userSevice.findUserByJwtToken(jwt);
        List<Restaurant> restaurant = restaurantSevice.getAllRestaurant();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable long id) throws Exception {

        User user = userSevice.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantSevice.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addToFavorites(
            @RequestHeader("Authorization") String jwt,
            @PathVariable long id) throws Exception {

        User user = userSevice.findUserByJwtToken(jwt);
        RestaurantDto restaurant = restaurantSevice.addToFavorites(id, user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

}
