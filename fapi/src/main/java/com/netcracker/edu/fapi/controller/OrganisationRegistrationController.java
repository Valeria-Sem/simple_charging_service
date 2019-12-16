package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.OrganisationRegistrationModel;
import com.netcracker.edu.fapi.service.OrganisationRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration/organisation")
public class OrganisationRegistrationController {

    private OrganisationRegistrationService organisationRegistrationService;

    @Autowired
    public OrganisationRegistrationController(OrganisationRegistrationService organisationRegistrationService) {
        this.organisationRegistrationService = organisationRegistrationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrganisationRegistrationModel> registerOrganisation (@RequestBody OrganisationRegistrationModel newOrganisation){
        if(newOrganisation != null) {
            return ResponseEntity.ok(organisationRegistrationService.registerOrganisation(newOrganisation));
        }
        return null;
    }

    @GetMapping("login/{log}/password/{pass}")
    public OrganisationRegistrationModel getOrganisationProfile(@PathVariable String log, @PathVariable String pass) {
        return organisationRegistrationService.getOrganisationProfile(log, pass);
    }
}
