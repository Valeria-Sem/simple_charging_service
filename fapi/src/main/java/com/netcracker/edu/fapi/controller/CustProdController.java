package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CustProdModel;
import com.netcracker.edu.fapi.service.CustProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customerSub/")
public class CustProdController {
    private CustProdService custProdService;

    @Autowired
    public CustProdController(CustProdService custProdService) {
        this.custProdService = custProdService;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<CustProdModel>> getCustomerSub(@PathVariable int id){
        return ResponseEntity.ok(custProdService.getCustomerSub(id));
    }

}
