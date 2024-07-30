package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.service.CategorySevice;
import com.example.demo.service.UserService;



@RestController
@RequestMapping("/api")
public class CategoriControler {
    @Autowired
    private CategorySevice categorySevice;

    @Autowired
    private UserService userSevice;

    @PostMapping("admin/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category,
                                                    @RequestHeader("Authorization")String jwt) throws Exception{
    User user = userSevice.findUserByJwtToken(jwt);
    Category createCategory = categorySevice.createCategory(category.getName(), user.getId());
    return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    } 


    @GetMapping("/category/restaurant")
    public ResponseEntity<List<Category>> getRestaurantCategory(@RequestBody Category category,
                                                    @RequestHeader("Authorization")String jwt) throws Exception{
    User user = userSevice.findUserByJwtToken(jwt);
    List<Category> categories = categorySevice.findCategoryByRestaurantId(user.getId());
    return new ResponseEntity<>(categories, HttpStatus.CREATED);
    } 
}
