package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UsersEntity;

import java.util.List;

public interface UsersEntityService {

    Iterable<UsersEntity> getAllUsers();
    UsersEntity findByLogin(String login);
    UsersEntity save(UsersEntity usersEntity);
    void delete(long id);
}
