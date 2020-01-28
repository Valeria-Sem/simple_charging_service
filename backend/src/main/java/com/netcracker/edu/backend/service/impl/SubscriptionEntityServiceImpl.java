package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.entity.enums.SubStatus;
import com.netcracker.edu.backend.repository.CustomerEntityRepository;
import com.netcracker.edu.backend.repository.SubscriptionEntityRepository;
import com.netcracker.edu.backend.service.CustomerEntityService;
import com.netcracker.edu.backend.service.ProductEntityService;
import com.netcracker.edu.backend.service.SubscriptionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//import java.sql.Date;

@Service
public class SubscriptionEntityServiceImpl implements SubscriptionEntityService {
    private SubscriptionEntityRepository subscriptionEntityRepository;
    private CustomerEntityService customerEntityService;
    private ProductEntityService productEntityService;

    @Autowired
    public SubscriptionEntityServiceImpl(SubscriptionEntityRepository subscriptionEntityRepository, CustomerEntityRepository customerEntityRepository, CustomerEntityService customerEntityService, ProductEntityService productEntityService) {
        this.subscriptionEntityRepository = subscriptionEntityRepository;
       // this.customerEntityRepository = customerEntityRepository;
        this.customerEntityService = customerEntityService;
        this.productEntityService = productEntityService;
    }

    @Override
    public SubscriptionEntity subscribeUser(SubscriptionEntity subscriptionEntity, int idCus, int idProd) {
        CustomerEntity customer = customerEntityService.getCustomerById(idCus);
        ProductEntity product = productEntityService. getProductById(idProd);
        subscribe(subscriptionEntity, customer, product);
        return null;
    }

    private void subscribe(SubscriptionEntity subscriptionEntity, CustomerEntity customer, ProductEntity product) {
        SubscriptionEntity subscription = new SubscriptionEntity();
        subscription.setIdSubscription(subscriptionEntity.getIdSubscription());
        subscription.setCustomerByIdCustomers(customer);
        subscription.setProductByIdProduct(product);
        subscription.setSubscriptionStatus(subscriptionEntity.getSubscriptionStatus());
        subscription.setDateOfSubscription(subscriptionEntity.getDateOfSubscription());

        List<SubscriptionEntity> sub = subscriptionEntityRepository.getSubscriptionEntitiesByCustomerByIdCustomers(customer);
        boolean save = true;
        for (SubscriptionEntity subscr: sub){
            if (subscr.getProductByIdProduct() == subscription.getProductByIdProduct()){
                save = false;
            }
        }
        if(save != false){
            subscriptionEntityRepository.save(subscription);
        }

    }

    @Override
    public void deleteSub(Integer id) {
        subscriptionEntityRepository.deleteById(id);
    }

    @Override
    public List<SubscriptionEntity> getCustomerSub(int idCust) {
        CustomerEntity customer = customerEntityService.getCustomerById(idCust);
        return subscriptionEntityRepository.getSubscriptionEntitiesByCustomerByIdCustomers(customer);
    }

    @Override
    public List<SubscriptionEntity> getAllSubs() {
        return subscriptionEntityRepository.findAll();
    }

    @Override
    public SubscriptionEntity saveSub(SubscriptionEntity sub) {
        return subscriptionEntityRepository.save(sub);
    }
}
