package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CustomerModel;
import com.netcracker.edu.fapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public ResponseEntity<List<CustomerModel>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerModel> saveCustomer (@RequestBody CustomerModel customer){
        if(customer != null) {
            return ResponseEntity.ok(customerService.saveCustomer(customer));
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(Long.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable String id) throws InterruptedException {
        Long customerId = Long.valueOf(id);
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
}
