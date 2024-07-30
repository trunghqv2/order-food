package com.example.demo.request;

import java.util.List;

import com.example.demo.model.Address;
import com.example.demo.model.ContactInformation;

import lombok.Data;

@Data
public class CreateRestaurantRequest {
    private long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contact_information;
    private String opning_hours;
    private List<String>images;
}
