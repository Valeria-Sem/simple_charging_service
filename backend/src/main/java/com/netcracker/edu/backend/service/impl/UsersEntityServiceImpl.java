package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.repository.UsersEntityRepository;
import com.netcracker.edu.backend.service.UsersEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersEntityServiceImpl implements UsersEntityService {

    @Autowired
    private UsersEntityRepository usersEntityRepository;

    @Override
    public Iterable<UsersEntity> getAllUsers() {
        return usersEntityRepository.findAll();
    }

    @Override
    public UsersEntity findByLogin(String login) {
        return usersEntityRepository.findByLogin(login);
    }

    @Override
    public UsersEntity save(UsersEntity usersEntity) {
        return usersEntityRepository.save(usersEntity);
    }

    @Override
    public void delete(long id) {
        usersEntityRepository.deleteById(id);
    }
}
