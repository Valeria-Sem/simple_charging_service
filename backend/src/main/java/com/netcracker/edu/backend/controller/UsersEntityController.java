package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.service.UsersEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersEntityController {

    @Autowired
    private UsersEntityService usersEntityService;

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<UsersEntity> getUsersByLogin(@PathVariable(name = "login") String login) {
        UsersEntity usersEntity = usersEntityService.findByLogin(login);
        return ResponseEntity.ok(usersEntity);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UsersEntity> getAllUsers(){
        return usersEntityService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UsersEntity saveUser(@RequestBody UsersEntity usersEntity){
        return usersEntityService.save(usersEntity);
    }
}
