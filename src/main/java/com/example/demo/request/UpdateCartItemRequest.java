package com.example.demo.request;

import lombok.Data;

@Data
public class UpdateCartItemRequest {
    private long cartItemId;
    private int quanity;
}
