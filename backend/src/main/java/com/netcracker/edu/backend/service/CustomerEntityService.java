package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerEntityService {
    CustomerEntity saveCustomer(CustomerEntity customer);
    Optional<CustomerEntity> getCustomerById(long id);
    Iterable<CustomerEntity> getAllCustomers();
    void deleteCustomer(Integer id);
}
