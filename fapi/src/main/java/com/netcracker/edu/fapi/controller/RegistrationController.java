package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.models.OrganisationRegistrationModel;
import com.netcracker.edu.fapi.service.CustomerRegistrationService;
import com.netcracker.edu.fapi.service.OrganisationRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private CustomerRegistrationService customerRegistrationService;
    private OrganisationRegistrationService organisationRegistrationService;

    public RegistrationController(CustomerRegistrationService customerRegistrationService, OrganisationRegistrationService organisationRegistrationService) {
        this.customerRegistrationService = customerRegistrationService;
        this.organisationRegistrationService = organisationRegistrationService;
    }

    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public ResponseEntity<CustomerRegistrationModel> registerCustomer (@RequestBody CustomerRegistrationModel newCustomer){
        if(newCustomer != null) {
            return ResponseEntity.ok(customerRegistrationService.registerCustomer(newCustomer));
        }
        return null;
    }

    @GetMapping("/customer/login/{log}/password/{pass}")
    public CustomerRegistrationModel getCustomerProfile(@PathVariable String log, @PathVariable String pass) {
        return customerRegistrationService.getCustomerProfile(log, pass);
    }

    @RequestMapping(value = "/organisation",method = RequestMethod.POST)
    public ResponseEntity<OrganisationRegistrationModel> registerOrganisation (@RequestBody OrganisationRegistrationModel newOrganisation){
        if(newOrganisation != null) {
            return ResponseEntity.ok(organisationRegistrationService.registerOrganisation(newOrganisation));
        }
        return null;
    }

    @GetMapping("/organisation/login/{log}/password/{pass}")
    public OrganisationRegistrationModel getOrganisationProfile(@PathVariable String log, @PathVariable String pass) {
        return organisationRegistrationService.getOrganisationProfile(log, pass);
    }

}
