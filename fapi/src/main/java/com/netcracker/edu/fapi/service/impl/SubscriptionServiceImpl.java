package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Value("http://localhost:8080")
    private String backendServerUrl;


    @Override
    public SubscriptionModel subscribeUser(SubscriptionModel subscriptionModel, int idCust, int idProd) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subscription/cust/" + idCust + "/prod/" + idProd, subscriptionModel, SubscriptionModel.class).getBody();
    }
}
