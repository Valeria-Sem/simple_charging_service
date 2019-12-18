package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @RequestMapping(value = "/cust/{idCust}/prod/{idProd}",method = RequestMethod.POST)
    public ResponseEntity<SubscriptionModel> subUser (
            @PathVariable int idCust,
            @PathVariable int idProd
            ,@RequestBody SubscriptionModel subscriptionModel) {
        if(subscriptionModel != null) {
            return ResponseEntity.ok(subscriptionService.subscribeUser(subscriptionModel, idCust, idProd));
        }
        return null;
    }
}
