package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.repository.CategoryEntityRepository;
import com.netcracker.edu.backend.repository.OrganisationEntityRepository;
import com.netcracker.edu.backend.service.OrganisationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganisationEntityServiceImpl implements OrganisationEntityService {

    private OrganisationEntityRepository repository;

    @Autowired
    public OrganisationEntityServiceImpl(OrganisationEntityRepository repository) {
        this.repository = repository;
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
    public void deleteCategory(int id) {
        repository.deleteById(id);
    }
}
