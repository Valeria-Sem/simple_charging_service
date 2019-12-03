package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customerReg")
public class CustomerRegistrationController {

    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerRegistrationModel> registrationCustomer (@RequestBody CustomerRegistrationModel customerReg){
        if(customerReg != null) {
            return ResponseEntity.ok(customerRegistrationService.registrationCustomer(customerReg));
        }
        return null;
    }

}
