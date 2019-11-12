package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Organisation;

import java.util.List;

public interface OrganisationService {
    List<Organisation> getAll();
    Organisation getOrganisationById(Long id);
    Organisation saveOrganisation(Organisation organisation);
    void deleteOrganisation(Long id);
}
