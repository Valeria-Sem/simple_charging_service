package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Users;
import com.netcracker.edu.fapi.service.UsersSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    private UsersSevice usersSevice;

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Users> save(@RequestBody Users user) {
//        if(user != null) {
//            return ResponseEntity.ok(usersSevice.save(user));
//        }
//        return null;
//    }
//
//    @GetMapping
//    public List<Users> getAllUsers() {
//        return usersSevice.findAll();
//        Users users = new Users();
//
//        users.setId(1);
//        users.setPassword("gggggg");
//        users.setLogin("qqqqq");
//        List list = new ArrayList<Users>();
//        list.add(users);
//
//        return list;
 //   }
     @GetMapping()
    public Users getUsersByLogin(@RequestParam(name = "login") String login) {
        return usersSevice.findByLogin(login);
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json")
//    public Users saveUser(@RequestBody Users users){
//        return usersSevice.save(users);
//    }
}
