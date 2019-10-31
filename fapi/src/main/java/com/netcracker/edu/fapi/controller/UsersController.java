package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Users;
import com.netcracker.edu.fapi.service.UsersSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    private UsersSevice usersSevice;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Users> getAllUsers() {
        return usersSevice.findAll();
    }

     @GetMapping("/login/{login}")
     public Users getUsersByLogin(@PathVariable String login){
        return usersSevice.findByLogin(login);
     }

     @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json")
     public Users saveUser(@RequestBody Users users){
        return usersSevice.save(users);
     }
}
