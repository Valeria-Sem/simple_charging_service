package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.service.CustomerEntityService;
import com.netcracker.edu.backend.service.UsersEntityService;
import com.netcracker.edu.backend.service.WalletEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/new/customer")
public class CustomerRegistrationController {
    @Autowired
    private CustomerEntityService customerEntityService;

    @Autowired
    private UsersEntityService usersEntityService;

    @Autowired
    private WalletEntityService walletEntityService;

    @RequestMapping(method = RequestMethod.POST)
    public UsersEntity saveCustomer(@RequestBody CustomerEntity customerEntity){

 //       return customerEntityService.saveCustomer(customerEntity);
    }
}
