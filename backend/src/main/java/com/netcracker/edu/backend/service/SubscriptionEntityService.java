package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.SubscriptionEntity;

public interface SubscriptionEntityService {
    SubscriptionEntity subscribeUser(SubscriptionEntity subscriptionEntity, int idCus, int idProd);
    void deleteSub(Integer id);
}
