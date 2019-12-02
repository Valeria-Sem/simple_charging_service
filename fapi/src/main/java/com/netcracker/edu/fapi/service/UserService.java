package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserModel;

import java.util.List;

public interface UserService {
    UserModel saveUser (UserModel user);
    UserModel findByLogin(String login);
    List<UserModel> getAll();
    void deleteUser (int id);
}
