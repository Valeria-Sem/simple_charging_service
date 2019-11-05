package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersEntityRepository extends CrudRepository<UsersEntity, Long >{
    UsersEntity findByLogin(String login);
}
