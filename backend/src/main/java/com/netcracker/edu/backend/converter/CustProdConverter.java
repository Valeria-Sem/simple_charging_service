package com.netcracker.edu.backend.converter;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.service.CustomerEntityService;
import com.netcracker.edu.backend.service.ProductEntityService;
import com.netcracker.edu.backend.service.SubscriptionEntityService;
import com.netcracker.edu.backend.transferOfObjects.CustomerProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/customerSub")
public class CustProdConverter {
    private CustomerEntityService customerEntityService;
    private SubscriptionEntityService subscriptionEntityService;
    private ProductEntityService productEntityService;

    @Autowired
    public CustProdConverter(CustomerEntityService customerEntityService,
                             SubscriptionEntityService subscriptionEntityService,
                             ProductEntityService productEntityService) {
        this.customerEntityService = customerEntityService;
        this.subscriptionEntityService = subscriptionEntityService;
        this.productEntityService = productEntityService;
    }

    @GetMapping
    @RequestMapping(value = "/customer/{id}")
    public ResponseEntity<List<CustomerProductModel>> convertSubToProductByIdCust(@PathVariable String id) {
        Integer customerId = Integer.valueOf(id);
        List<SubscriptionEntity> subs = subscriptionEntityService.getCustomerSub(customerId);
        Iterable<ProductEntity> products = productEntityService.getAllProducts();
        List<CustomerProductModel> convertSubscription = fillConvertModel(subs, products);
        return ResponseEntity.ok(convertSubscription == null ? Collections.emptyList() : convertSubscription);
    }

    public List<CustomerProductModel> fillConvertModel(List<SubscriptionEntity> subs, Iterable<ProductEntity> products){
        List<CustomerProductModel> convertSubscription = new ArrayList<>();
        for(SubscriptionEntity subsItem: subs) {
            CustomerProductModel custProd = new CustomerProductModel();
            custProd.setIdSubscription(subsItem.getIdSubscription());
            for(ProductEntity prodItem: products) {
                if (subsItem.getProductByIdProduct() == prodItem){
                    custProd.setName(prodItem.getName());
                    custProd.setDescription(prodItem.getDescription());
                    custProd.setMonthPrise(prodItem.getMonthPrise());
                    custProd.setImg(prodItem.getImg());
                }
            }
            convertSubscription.add(custProd);
        }
        return convertSubscription;
    }

}
