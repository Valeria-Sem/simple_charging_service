package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CustomerModel;

import java.util.List;

public interface CustomerService {
    List<CustomerModel> getAll();
    CustomerModel getCustomerById(Long id);
    CustomerModel saveCustomer(CustomerModel customer);
    void deleteCustomer(Long id);
}
