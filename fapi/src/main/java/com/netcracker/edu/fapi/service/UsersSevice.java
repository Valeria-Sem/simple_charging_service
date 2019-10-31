package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Users;

import java.util.List;

public interface UsersSevice {

    Users findByLogin(String login);
    List<Users> findAll();
    Users save(Users user);
}
