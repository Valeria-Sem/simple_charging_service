package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.OrganisationRegistrationModel;
import com.netcracker.edu.fapi.service.OrganisationRegistrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrganisationRegistrationServiceImpl implements OrganisationRegistrationService {
    @Value("http://localhost:8080")
    private String backendServerUrl;

    @Override
    public OrganisationRegistrationModel registerOrganisation(OrganisationRegistrationModel newOrganisation) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/registration/organisation", newOrganisation, OrganisationRegistrationModel.class).getBody();
    }
    @Override
    public OrganisationRegistrationModel getOrganisationProfile(String log, String pass) {
        RestTemplate restTemplate = new RestTemplate();
        OrganisationRegistrationModel organisationRegistrationModel = restTemplate.getForObject(backendServerUrl + "/api/registration/organisation/login/" + log + "/password/" + pass, OrganisationRegistrationModel.class);
        return organisationRegistrationModel;
    }
}
