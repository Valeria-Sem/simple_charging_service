package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserViewModel;

import java.util.List;

public interface UserService {
    UserViewModel saveUser (UserViewModel user);
    UserViewModel findByLogin(String login);
    List<UserViewModel> getAll();
    void deleteUser (int id);
}
