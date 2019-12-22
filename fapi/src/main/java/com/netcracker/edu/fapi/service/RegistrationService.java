package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.AbstractRegModel;
import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.models.OrganisationRegistrationModel;

public interface RegistrationService {
    AbstractRegModel registerOrganisation (OrganisationRegistrationModel newOrganisation);
    AbstractRegModel registerCustomer(CustomerRegistrationModel newCustomer);
    AbstractRegModel getUserProfile(String log, String pass);
    //AbstractRegModel getCustProfile(String log, String pass);
    void deleteUserProfile(int idUser, int idWallet);
}
