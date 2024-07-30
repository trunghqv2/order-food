package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RestaurantDto;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.request.CreateRestaurantRequest;

public interface RestaurantService {
    public Restaurant createRestaurant(CreateRestaurantRequest req , User user) throws Exception;

    public Restaurant updateRestaurant(Long restaurantId,CreateRestaurantRequest updateRestaurant) throws Exception;

    public void deletRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();
    
    public List<Restaurant> sreachRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws Exception;

    public Restaurant getRestaurantByUserId(long userId) throws Exception;

    public RestaurantDto addToFavorites(Long restaurantId , User user ) throws Exception;

    public Restaurant updateRestaurantStatus(Long id) throws Exception;
}
