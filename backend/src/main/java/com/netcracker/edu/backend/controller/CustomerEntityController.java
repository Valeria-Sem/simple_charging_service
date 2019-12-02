package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.CustomerEntity;
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
    public Iterable<CustomerEntity> getAllWallets(){
        return customerEntityService.getAllCustomers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public CustomerEntity saveWallet(@RequestBody CustomerEntity walletEntity){
        return customerEntityService.saveCustomer(walletEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerEntity> getWalletById(@PathVariable(name ="id") Integer id) {
        Optional<CustomerEntity> wallet = customerEntityService.getCustomerById(id);
        if (wallet.isPresent()) {
            return ResponseEntity.ok(wallet.get());
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteWallet(@PathVariable(name = "id") Integer id) {
        customerEntityService.deleteCustomer(id);
    }
}
