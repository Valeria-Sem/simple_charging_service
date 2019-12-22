package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.repository.UsersEntityRepository;
import com.netcracker.edu.backend.service.UsersEntityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public UsersEntity getUserIdByLoginAndPassword(String login, String password) {
        UsersEntity user = usersEntityRepository.getUserIdByLoginAndPassword(login, password);
        if (user == null) {
            throw new Error("Invalid login or password");
//            try {
//                UsersEntity user = usersEntityRepository.getUserIdByLoginAndPassword(login, password);
//                throw new Error();
//            } catch (NotFoundException e){
//                throw new RuntimeException(e.getMessage(), e);
//                throw new Error();
//            }
        } else {
            return usersEntityRepository.getUserIdByLoginAndPassword(login, password);
        }
    }

    @Override
    public void delete(int id) {
        usersEntityRepository.deleteById(id);
    }
}
