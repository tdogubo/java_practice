package com.etz.practice.controller;

import com.etz.practice.model.UserModel;
import com.etz.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody UserModel user){
        userService.addNewUser(user);
    }

    @GetMapping("/designation")
    public ResponseEntity<List<UserModel>> userByDesignation(@RequestParam String designation){
        return userService.userByDesignation(designation);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false)String firstName,
                           @RequestParam(required = false)String lastName){
        userService.updateUser(userId, firstName,lastName);
    }


}
