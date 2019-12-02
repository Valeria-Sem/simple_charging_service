package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.OrganisationModel;
import com.netcracker.edu.fapi.service.OrganisationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<OrganisationModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        OrganisationModel[] organisationsResponse = restTemplate.getForObject(backendServerUrl + "/api/organisation", OrganisationModel[].class);
        return organisationsResponse == null? Collections.emptyList() : Arrays.asList(organisationsResponse);
    }

    @Override
    public OrganisationModel getOrganisationById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/organisation/" + id, OrganisationModel.class);
    }

    @Override
    public OrganisationModel saveOrganisation(OrganisationModel organisation) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/organisation", organisation, OrganisationModel.class).getBody();
    }

    @Override
    public void deleteOrganisation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/organisation" + id);
    }
}
