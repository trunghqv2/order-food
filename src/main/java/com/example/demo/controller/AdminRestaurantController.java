package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.request.CreateRestaurantRequest;
import com.example.demo.response.MessageResponse;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admin/restaurants")
@RestController
public class AdminRestaurantController {
    @Autowired
    private UserService userSevice;

    @Autowired
    private RestaurantService restaurantSevice;

    @PostMapping("")
    public ResponseEntity<Restaurant> createRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantSevice.createRestaurant(req, user);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantSevice.updateRestaurant(id, req);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        restaurantSevice.deletRestaurant(id);
        MessageResponse res = new MessageResponse();
        res.setMessage("restaurant deleted successfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantSevice.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Restaurant> findRestauntByUserId(
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userSevice.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantSevice.getRestaurantByUserId(user.getId());

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
