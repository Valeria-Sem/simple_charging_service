package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.entity.UsersEntity;

import java.util.Optional;

public interface OrganisationEntityService {

    OrganisationEntity saveOrganisation (OrganisationEntity organisation);
    Optional<OrganisationEntity> getOrganisationById(int id);
    Iterable<OrganisationEntity> getAllOrganisations();
    OrganisationEntity getOrganisationByIdUser(UsersEntity usersEntity);
    OrganisationEntity getOrganisationByIdOrganisation(int idOrg);
    void deleteCategory(int id);
}
