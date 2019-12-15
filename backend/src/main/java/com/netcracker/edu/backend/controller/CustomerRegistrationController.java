package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.service.CustomerEntityService;
import com.netcracker.edu.backend.service.CustomerRegistrationService;
import com.netcracker.edu.backend.service.UsersEntityService;
import com.netcracker.edu.backend.service.WalletEntityService;
import com.netcracker.edu.backend.transferOfObjects.CustomerRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class CustomerRegistrationController {

    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @RequestMapping(value = "/login/{login}/password/{password}", method = RequestMethod.GET)
    public ResponseEntity<CustomerRegistration> getRegisteredProfile(
            @PathVariable(name = "login") String login,
            @PathVariable(name = "password") String password) {
       CustomerRegistration customer =  customerRegistrationService.getCustomerProfileInformation(login, password);
        return ResponseEntity.ok(customer);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CustomerRegistration registerCustomer(@RequestBody CustomerRegistration customerRegistration){
        return customerRegistrationService.registerCustomer(customerRegistration);
    }
}
