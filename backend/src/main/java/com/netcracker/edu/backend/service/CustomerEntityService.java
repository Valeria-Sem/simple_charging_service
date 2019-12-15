package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.UsersEntity;

import java.util.Optional;

public interface CustomerEntityService {
    CustomerEntity saveCustomer(CustomerEntity customer);
    Optional<CustomerEntity> getCustomerById(long id);
    Iterable<CustomerEntity> getAllCustomers();
    CustomerEntity getCustomerEntityByUsersByIdUsers(UsersEntity usersEntity);

    void deleteCustomer(long id);
}
