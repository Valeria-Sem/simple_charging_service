package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.transferOfObjects.CustomerRegistration;

public interface CustomerRegistrationService {
    CustomerRegistration registerCustomer(CustomerRegistration registration);
    CustomerRegistration getCustomerProfileInformation(String log, String pas);
}
