package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {

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
    public UserModel getUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

//    @GetMapping("/login/{login}/password/{pass}")
//    public UserModel getUserByLoginAndPass(@PathVariable String login,
//                                           @PathVariable String pass) {
//        return userService.findByLoginPass(login, pass);
//    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
