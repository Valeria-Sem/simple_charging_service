package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Organisation;
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
    public List<Organisation> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Organisation[] organisationsResponse = restTemplate.getForObject(backendServerUrl + "/api/organisation", Organisation[].class);
        return organisationsResponse == null? Collections.emptyList() : Arrays.asList(organisationsResponse);
    }

    @Override
    public Organisation getOrganisationById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/organisation/" + id, Organisation.class);
    }

    @Override
    public Organisation saveOrganisation(Organisation organisation) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/organisation", organisation, Organisation.class).getBody();
    }

    @Override
    public void deleteOrganisation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/organisation" + id);
    }
}
