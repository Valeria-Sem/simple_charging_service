package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerEntityRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity getCustomerEntityByUsersByIdUsers(UsersEntity usersEntity);
}
