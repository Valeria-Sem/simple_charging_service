package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersEntityRepository extends CrudRepository<UsersEntity, Integer >{
    UsersEntity findByLogin(String login);
    UsersEntity getUserIdByLoginAndPassword(String login, String password);
}
