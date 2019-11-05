package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UsersEntity;

import java.util.List;

public interface UsersEntityService {

    List<UsersEntity> findAll();
    UsersEntity findByLogin(String login);
    UsersEntity save(UsersEntity usersEntity);
    void delete(long id);
}
