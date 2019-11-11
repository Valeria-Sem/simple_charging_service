package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.OrganisationEntity;

import java.util.Optional;

public interface OrganisationEntityService {

    OrganisationEntity saveOrganisation (OrganisationEntity organisation);
    Optional<OrganisationEntity> getOrganisationById(int id);
    Iterable<OrganisationEntity> getAllOrganisations();
    void deleteCategory(int id);
}
