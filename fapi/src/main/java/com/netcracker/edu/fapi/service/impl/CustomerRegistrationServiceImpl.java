package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
    @Value("http://localhost:8080")
    private String backendServerUrl;

    @Override
    public CustomerRegistrationModel registerCustomer(CustomerRegistrationModel newCustomer) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/registration/customer", newCustomer, CustomerRegistrationModel.class).getBody();
    }

    @Override
    public CustomerRegistrationModel getCustomerProfile(String log, String pass) {
        RestTemplate restTemplate = new RestTemplate();
        CustomerRegistrationModel customerRegistrationModel = restTemplate.getForObject(backendServerUrl + "/api/registration/customer/login/" + log + "/password/" + pass, CustomerRegistrationModel.class);
        return customerRegistrationModel;
    }
}
