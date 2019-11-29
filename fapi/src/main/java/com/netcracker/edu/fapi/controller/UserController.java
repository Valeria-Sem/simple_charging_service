package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
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
            return ResponseEntity.ok(userService.saveUser(user));
        }
        return null;
    }

//    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
//    public UserViewModel saveUser(@RequestBody UserViewModel user){
//        return userService.saveUser(user);
//    }

    @GetMapping("/login/{login}")
    public UserViewModel getUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(Integer.valueOf(id));
    }
}
