package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.models.WalletModel;
import com.netcracker.edu.fapi.service.CustomerRegistrationService;
import com.netcracker.edu.fapi.service.CustomerService;
import com.netcracker.edu.fapi.service.UserService;
import com.netcracker.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class CustomerRegistrationController {
    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerRegistrationModel> registerCustomer (@RequestBody CustomerRegistrationModel newCustomer){
        if(newCustomer != null) {
            return ResponseEntity.ok(customerRegistrationService.registerCustomer(newCustomer));
        }
        return null;
    }

    @GetMapping("/login/{log}/password/{pass}")
    public CustomerRegistrationModel getCustomerProfile(@PathVariable String log, @PathVariable String pass) {
        return customerRegistrationService.getCustomerProfile(log, pass);
    }

}
