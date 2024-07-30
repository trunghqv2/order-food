package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userSevice;

    @GetMapping("/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization")String jwt) throws Exception{
        User user = userSevice.findUserByJwtToken(jwt);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
