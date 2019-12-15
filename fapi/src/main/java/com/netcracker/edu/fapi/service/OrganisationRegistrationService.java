package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.OrganisationRegistrationModel;

public interface OrganisationRegistrationService {
    OrganisationRegistrationModel registerOrganisation (OrganisationRegistrationModel newOrganisation);
    OrganisationRegistrationModel getOrganisationProfile(String log, String pass);
}
