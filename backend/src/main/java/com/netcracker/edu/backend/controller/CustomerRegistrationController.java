package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.service.CustomerEntityService;
import com.netcracker.edu.backend.service.CustomerRegistrationService;
import com.netcracker.edu.backend.service.UsersEntityService;
import com.netcracker.edu.backend.service.WalletEntityService;
import com.netcracker.edu.backend.transferOfObjects.CustomerRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class CustomerRegistrationController {

    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @RequestMapping(method = RequestMethod.POST)
    public CustomerRegistration registerCustomer(@RequestBody CustomerRegistration customerRegistration){
        return customerRegistrationService.registerCustomer(customerRegistration);
    }
}
