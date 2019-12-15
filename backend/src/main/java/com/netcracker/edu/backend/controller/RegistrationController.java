package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.service.CustomerRegistrationService;
import com.netcracker.edu.backend.service.OrganisationRegistrationService;
import com.netcracker.edu.backend.transferOfObjects.CustomerRegistration;
import com.netcracker.edu.backend.transferOfObjects.OrganisationRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private CustomerRegistrationService customerRegistrationService;
    private OrganisationRegistrationService organisationRegistrationService;

    @Autowired
    public RegistrationController(CustomerRegistrationService customerRegistrationService, OrganisationRegistrationService organisationRegistrationService) {
        this.customerRegistrationService = customerRegistrationService;
        this.organisationRegistrationService = organisationRegistrationService;
    }

    @RequestMapping(value = "/customer/login/{login}/password/{password}", method = RequestMethod.GET)
    public ResponseEntity<CustomerRegistration> getCustomerRegisteredProfile(
            @PathVariable(name = "login") String login,
            @PathVariable(name = "password") String password) {
       CustomerRegistration customer =  customerRegistrationService.getCustomerProfileInformation(login, password);
        return ResponseEntity.ok(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public CustomerRegistration registerCustomer(@RequestBody CustomerRegistration customerRegistration){
        return customerRegistrationService.registerCustomer(customerRegistration);
    }

    @RequestMapping(value = "/organisation/login/{login}/password/{password}", method = RequestMethod.GET)
    public ResponseEntity<OrganisationRegistration> getOrganisationRegisteredProfile(
            @PathVariable(name = "login") String login,
            @PathVariable(name = "password") String password) {
        OrganisationRegistration organisation =  organisationRegistrationService.getOrganisationProfileInformation(login, password);
        return ResponseEntity.ok(organisation);
    }

    @RequestMapping(value = "/organisation", method = RequestMethod.POST)
    public OrganisationRegistration registerOrganisation(@RequestBody OrganisationRegistration organisationRegistration){
        return organisationRegistrationService.registerOrganisation(organisationRegistration);
    }
}
