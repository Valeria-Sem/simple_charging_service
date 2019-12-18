package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.repository.CustomerEntityRepository;
import com.netcracker.edu.backend.service.CustomerEntityService;
import com.netcracker.edu.backend.service.UsersEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerEntityServiceImpl implements CustomerEntityService{
    private CustomerEntityRepository customerRepository;
    private UsersEntityService usersEntityService;

    @Autowired
    public CustomerEntityServiceImpl(CustomerEntityRepository repository, UsersEntityService usersEntityService){
        this.customerRepository = repository;
        this.usersEntityService = usersEntityService;
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

//    @Override
//    public CustomerEntity getCustomer(SubscriptionEntity subscriptionEntity) {
//        return customerRepository.getCustomer(subscriptionEntity);
//    }

// todo вернуть назад метод Optional<CustomerEntity> getCustomerById(long id), а может и нет
    @Override
    public CustomerEntity getCustomerById(int id) {
        return customerRepository.getCustomerByIdCustomer(id);
    }

    @Override
    public Iterable<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerEntityByUsersByIdUsers(UsersEntity usersEntity) {
        usersEntity = usersEntityService.getUserIdByLoginAndPassword(usersEntity.getLogin(), usersEntity.getPassword());
        return customerRepository.getCustomerEntityByUsersByIdUsers(usersEntity);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
