package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.transferOfObjects.AbstractRegistrationModel;
import com.netcracker.edu.backend.transferOfObjects.OrganisationRegistration;

public interface RegistrationService {
    AbstractRegistrationModel registerUser(AbstractRegistrationModel abstractRegistrationModel);
    AbstractRegistrationModel getUserInfo(String log, String pas);
}
