package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping
//    public ResponseEntity<List<UserViewModel>> getAllCategories(){
//        return ResponseEntity.ok(userService.getAll());
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserViewModel> saveUser(@RequestBody UserViewModel user) {
        if(user != null) {
            System.out.println("memes");
            return ResponseEntity.ok(userService.saveUser(user));
        }
        return null;
    }

    @GetMapping("/login/{login}")
    public UserViewModel getUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(Integer.valueOf(id));
    }
}
