package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.service.OrganisationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/organisation")
public class OrganisationEntityController {

    private OrganisationEntityService organisationEntityService;

    @Autowired
    public OrganisationEntityController(OrganisationEntityService organisationEntityService) {
        this.organisationEntityService = organisationEntityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OrganisationEntity> getAllOrganisation() {
        return organisationEntityService.getAllOrganisations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrganisationEntity> getOrganisationById(@PathVariable(name = "id")int id) {
        Optional<OrganisationEntity> organisation = organisationEntityService.getOrganisationById(id);
        if (organisation.isPresent()) {
            return ResponseEntity.ok(organisation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteOrganisationEntity(@PathVariable(name = "id")int id) {
        organisationEntityService.deleteCategory(id);
    }


}
