package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SubscriptionModel;

public interface SubscriptionService {
    SubscriptionModel subscribeUser(SubscriptionModel subscriptionModel, int idCust, int idProd);
    void unsubscribe (int id);
}
