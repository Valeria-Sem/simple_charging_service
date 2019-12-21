package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;

import java.util.List;

public interface SubscriptionEntityService {
    SubscriptionEntity subscribeUser(SubscriptionEntity subscriptionEntity, int idCus, int idProd);
    void deleteSub(Integer id);
    List<SubscriptionEntity> getCustomerSub(int idCust);
    List<SubscriptionEntity> getAllSubs();

}
