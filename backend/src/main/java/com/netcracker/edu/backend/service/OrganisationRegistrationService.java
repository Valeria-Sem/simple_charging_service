package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.transferOfObjects.OrganisationRegistration;

public interface OrganisationRegistrationService {
    OrganisationRegistration registerOrganisation(OrganisationRegistration organisationRegistration);
    OrganisationRegistration getOrganisationProfileInformation(String log, String pas);
}
