package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.repository.CustomerEntityRepository;
import com.netcracker.edu.backend.service.CustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerEntityServiceImpl implements CustomerEntityService{
    private CustomerEntityRepository repository;

    @Autowired
    public CustomerEntityServiceImpl(CustomerEntityRepository repository){
        this.repository = repository;
    }


    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<CustomerEntity> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }
}
