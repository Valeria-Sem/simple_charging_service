package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CustomerModel;
import com.netcracker.edu.fapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Value("http://localhost:8080")
    private String backendServerUrl;

    @Override
    public List<CustomerModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        CustomerModel[] customerResponse = restTemplate.getForObject(backendServerUrl + "/api/customer", CustomerModel[].class);
        return customerResponse == null? Collections.emptyList() : Arrays.asList(customerResponse);
    }

    @Override
    public CustomerModel getCustomerById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/customer/" + id, CustomerModel.class);
    }

    @Override
    public CustomerModel saveCustomer(CustomerModel customer) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/customer", customer, CustomerModel.class).getBody();
    }

    @Override
    public void deleteCustomer(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/customer/delete/" + id);
    }
}
