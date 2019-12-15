package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.transferOfObjects.CustomerRegistration;
import com.netcracker.edu.backend.transferOfObjects.OrganisationRegistration;

public interface CustomerRegistrationService {
    CustomerRegistration registerCustomer(CustomerRegistration customerRegistration);
    CustomerRegistration getCustomerProfileInformation(String log, String pas);
}
