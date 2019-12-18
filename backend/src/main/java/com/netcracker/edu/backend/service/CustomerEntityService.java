package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.entity.UsersEntity;

import java.util.Optional;

public interface CustomerEntityService {
    CustomerEntity saveCustomer(CustomerEntity customer);
    //CustomerEntity getCustomer(SubscriptionEntity subscriptionEntity);
    CustomerEntity getCustomerById(int id);
    Iterable<CustomerEntity> getAllCustomers();
    CustomerEntity getCustomerEntityByUsersByIdUsers(UsersEntity usersEntity);

    void deleteCustomer(int id);
}
