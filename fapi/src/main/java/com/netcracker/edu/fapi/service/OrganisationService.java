package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.OrganisationModel;

import java.util.List;

public interface OrganisationService {
    List<OrganisationModel> getAll();
    OrganisationModel getOrganisationById(Long id);
//    OrganisationModel getWalletById(Long id);
    OrganisationModel saveOrganisation(OrganisationModel organisation);
    void deleteOrganisation(Long id);
}
