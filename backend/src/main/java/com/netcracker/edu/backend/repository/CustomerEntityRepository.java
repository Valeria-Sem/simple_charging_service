package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerEntityRepository extends CrudRepository<CustomerEntity, Integer> {
    CustomerEntity getCustomerEntityByUsersByIdUsers(UsersEntity usersEntity);
    CustomerEntity getCustomerByIdCustomer(Integer id);
}
