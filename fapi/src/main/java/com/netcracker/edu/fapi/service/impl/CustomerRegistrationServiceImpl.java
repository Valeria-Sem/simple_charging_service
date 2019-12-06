package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
    @Value("http://localhost:8080")
    private String backendServerUrl;

    @Override
    public CustomerRegistrationModel saveNewCustomer(CustomerRegistrationModel newCustomer) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/new/customer", newCustomer, CustomerRegistrationModel.class).getBody();
    }
}
