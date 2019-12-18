package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.service.SubscriptionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionEntityController {
    private SubscriptionEntityService subscriptionEntityService;

    @Autowired
    public SubscriptionEntityController(SubscriptionEntityService subscriptionEntityService) {
        this.subscriptionEntityService = subscriptionEntityService;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable(name = "id") Integer id) {
        subscriptionEntityService.deleteSub(id);
    }

    @RequestMapping(value = "/cust/{idCust}/prod/{idProd}",method = RequestMethod.POST)
    public SubscriptionEntity saveSubscription(
            @PathVariable(name = "idCust") Integer idCustomer,
            @PathVariable(name = "idProd") Integer idProduct,
            @RequestBody SubscriptionEntity subscriptionEntity){
        return subscriptionEntityService.subscribeUser(subscriptionEntity, idCustomer, idProduct);
    }
}
