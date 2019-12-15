package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CustomerRegistrationModel;

public interface CustomerRegistrationService {
    CustomerRegistrationModel registerCustomer (CustomerRegistrationModel newCustomer);
    CustomerRegistrationModel getCustomerProfile(String log, String pass);
}
