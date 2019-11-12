package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Organisation;
import com.netcracker.edu.fapi.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organisation")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @RequestMapping
    public ResponseEntity<List<Organisation>> getAllOrganisation(){
        return ResponseEntity.ok(organisationService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Organisation> saveOrganisation (@RequestBody Organisation organisation){
        if(organisation != null) {
            return ResponseEntity.ok(organisationService.saveOrganisation(organisation));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOrganisation(@PathVariable String id) { // почему String
        organisationService.deleteOrganisation(Long.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Organisation> getAllOrganisations(@PathVariable String id) throws InterruptedException {
        Long organisationId = Long.valueOf(id);
        return ResponseEntity.ok(organisationService.getOrganisationById(organisationId));
    }
}
