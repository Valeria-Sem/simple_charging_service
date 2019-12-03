package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.repository.CustomerEntityRepository;
import com.netcracker.edu.backend.service.CustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerEntityServiceImpl implements CustomerEntityService{
    private CustomerEntityRepository customerRepository;

    @Autowired
    public CustomerEntityServiceImpl(CustomerEntityRepository repository){
        this.customerRepository = repository;
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Iterable<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
