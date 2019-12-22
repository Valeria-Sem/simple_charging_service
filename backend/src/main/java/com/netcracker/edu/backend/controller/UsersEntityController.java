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

    @RequestMapping(value = "/login/{login}/{pass}", method = RequestMethod.GET)
    public ResponseEntity<UsersEntity> getUsersByLoginP(@PathVariable(name = "login") String login,
                                                        @PathVariable(name = "pass") String pass) {
        UsersEntity usersEntity = usersEntityService.getUserIdByLoginAndPassword(login, pass);
        return ResponseEntity.ok(usersEntity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") Integer id) {
        usersEntityService.delete(id);
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
