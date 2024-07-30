package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.request.OrderRequest;

public interface OrderService {
    public Order createOrder(OrderRequest order ,User user) throws Exception;

    public Order updateOrder (Long orderId, String orderStatus) throws Exception;

    public void calceOrder(Long orderId) throws Exception;

    public List<Order> getUserOrder(Long UserId) throws Exception;
    
    public List<Order> getRestaurantsOrder(Long restaurantId,String orderStatus) throws Exception;

    public Order findOrderById (Long orderId) throws Exception;

}
