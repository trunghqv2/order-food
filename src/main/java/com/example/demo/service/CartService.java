package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import com.example.demo.request.AddCartItemRequest;

public interface CartService {
    public CartItem addItemToCart(AddCartItemRequest req ,String jwt) throws Exception;
    public CartItem updateCartItemQuanity(Long cartitemId , int quanity)throws Exception;
    public Cart removeItemFromCart(Long cartItemId ,String jwt) throws Exception;
    public Long calucateCartTotals(Cart cart) throws Exception;
    public Cart findCartbyId (Long id)throws Exception;
    public Cart findCartByUserId ( Long userId)throws Exception;
    public Cart clearCart(Long userId)throws Exception;

}
