package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.repository.OrganisationEntityRepository;
import com.netcracker.edu.backend.service.OrganisationEntityService;
import com.netcracker.edu.backend.service.UsersEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganisationEntityServiceImpl implements OrganisationEntityService {

    private OrganisationEntityRepository repository;
    private UsersEntityService usersEntityService;

    @Autowired
    public OrganisationEntityServiceImpl(OrganisationEntityRepository repository, UsersEntityService usersEntityService) {
        this.repository = repository;
        this.usersEntityService = usersEntityService;
    }

    @Override
    public OrganisationEntity saveOrganisation(OrganisationEntity organisation) {
        return repository.save(organisation);
    }

    @Override
    public Optional<OrganisationEntity> getOrganisationById(int id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<OrganisationEntity> getAllOrganisations() {
        return repository.findAll();
    }

    @Override
    public OrganisationEntity getOrganisationByIdUser(UsersEntity usersEntity) {
        usersEntity = usersEntityService.getUserIdByLoginAndPassword(usersEntity.getLogin(), usersEntity.getPassword());
        return repository.getOrganisationEntityByUsersByIdUsers(usersEntity);
    }

    @Override
    public OrganisationEntity getOrganisationByIdOrganisation(int idOrg) {
        return repository.getOrganisationByIdOrganisation(idOrg);
    }

    @Override
    public void deleteCategory(int id) {
        repository.deleteById(id);
    }
}
