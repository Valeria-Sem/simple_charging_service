package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.AbstractRegModel;
import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.models.OrganisationRegistrationModel;
import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.models.enums.Role;
import com.netcracker.edu.fapi.service.RegistrationService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Value("http://localhost:8080")
    private String backendServerUrl;

    private UserService userService;

    @Override
    public AbstractRegModel registerOrganisation(OrganisationRegistrationModel newOrganisation) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/registration/organisation", newOrganisation, OrganisationRegistrationModel.class).getBody();
    }

    @Override
    public AbstractRegModel registerCustomer(CustomerRegistrationModel newCustomer) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/registration/customer", newCustomer, CustomerRegistrationModel.class).getBody();
    }

    @Override
    public AbstractRegModel getUserProfile(String log, String pass) {
        RestTemplate restTemplate = new RestTemplate();
        UserModel user = userService.findByLogin(log);
        if (user.getRole().equals(Role.CUSTOMER)){
            return restTemplate.getForObject(backendServerUrl + "/api/registration/login/" + log + "/password/" + pass, CustomerRegistrationModel.class);

        } else {
            return restTemplate.getForObject(backendServerUrl + "/api/registration/login/" + log + "/password/" + pass, OrganisationRegistrationModel.class);
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
