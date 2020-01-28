package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.service.CustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerEntityController {
    @Autowired
    private CustomerEntityService customerEntityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<CustomerEntity> getAllCustomers(){
        return customerEntityService.getAllCustomers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public CustomerEntity saveCustomer(@RequestBody CustomerEntity customerEntity){
        return customerEntityService.saveCustomer(customerEntity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable(name = "id") Integer id) {
        customerEntityService.deleteCustomer(id);
    }
}
