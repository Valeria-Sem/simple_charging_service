package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.service.CustomerProductService;
import com.netcracker.edu.backend.transferOfObjects.CustomerProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/custProd")
public class CustomerProductController {
    private CustomerProductService customerProductService;

    @Autowired
    public CustomerProductController(CustomerProductService customerProductService) {
        this.customerProductService = customerProductService;
    }

    @RequestMapping(value = "/idCust/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerProductModel> getCustProd(
            @PathVariable(name = "id") int id) {
        CustomerProductModel information =  customerProductService.getProductsByCustomer(id);
        return ResponseEntity.ok(information);
    }
}
