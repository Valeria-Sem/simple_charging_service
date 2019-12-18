package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.entity.WalletEntity;
import com.netcracker.edu.backend.entity.enums.UsersRole;
import com.netcracker.edu.backend.service.*;
import com.netcracker.edu.backend.transferOfObjects.AbstractRegistrationModel;
import com.netcracker.edu.backend.transferOfObjects.CustomerRegistration;
import com.netcracker.edu.backend.transferOfObjects.OrganisationRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private OrganisationEntityService organisationEntityService;
    private WalletEntityService walletEntityService;
    private UsersEntityService usersEntityService;
    private CustomerEntityService customerEntityService;

    @Autowired
    public RegistrationServiceImpl(OrganisationEntityService organisationEntityService, WalletEntityService walletEntityService, UsersEntityService usersEntityService, CustomerEntityService customerEntityService) {
        this.organisationEntityService = organisationEntityService;
        this.walletEntityService = walletEntityService;
        this.usersEntityService = usersEntityService;
        this.customerEntityService = customerEntityService;
    }


    @Override
    public AbstractRegistrationModel registerUser(AbstractRegistrationModel abstractRegistrationModel) {
        UsersEntity user = saveNewUser(abstractRegistrationModel);
        WalletEntity wallet = saveNewWallet(abstractRegistrationModel);
        if (user.getRole().equals(UsersRole.CUSTOMER)){
            saveNewCustomer((CustomerRegistration) abstractRegistrationModel, user, wallet );
        } else {saveNewOrganisation((OrganisationRegistration) abstractRegistrationModel, user, wallet );}

            abstractRegistrationModel.setIdUser(user.getIdUsers());
            abstractRegistrationModel.setIdWallet(wallet.getIdWallet());
            return abstractRegistrationModel;
    }

    private WalletEntity saveNewWallet(AbstractRegistrationModel info){
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setBalance(info.getBalance());
        walletEntity.setWalletStatus(info.getWalletStatus());
        walletEntityService.saveWallet(walletEntity);
        return walletEntity;
    }

    private UsersEntity saveNewUser(AbstractRegistrationModel info){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setLogin(info.getLogin());
        usersEntity.setPassword(info.getPassword());
        usersEntity.setRole(info.getRole());
        usersEntityService.save(usersEntity);
        return usersEntity;
    }

    private void saveNewOrganisation(OrganisationRegistration info, UsersEntity user, WalletEntity wallet){
        OrganisationEntity organisationEntity = new OrganisationEntity();
        organisationEntity.setName(info.getName());
        organisationEntity.seteMail(info.geteMail());
        organisationEntity.setLinkOfSite(info.getLinkOfSite());
        organisationEntity.setPhone(info.getPhone());
        organisationEntity.setUsersByIdUsers(user);
        organisationEntity.setWalletByIdWallet(wallet);
        organisationEntityService.saveOrganisation(organisationEntity);
    }

    private void saveNewCustomer(CustomerRegistration info, UsersEntity user, WalletEntity wallet){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(info.getName());
        customerEntity.setSurname(info.getSurname());
        customerEntity.seteMail(info.geteMail());
        customerEntity.setUsersByIdUsers(user);
        customerEntity.setWalletByIdWallet(wallet);
        customerEntityService.saveCustomer(customerEntity);
    }

    @Override
    public AbstractRegistrationModel getUserInfo(String log, String pas) {
        UsersEntity usersEntity = usersEntityService.getUserIdByLoginAndPassword(log, pas);
        if(usersEntity.getRole().equals(UsersRole.ORGANISATION)) {
            OrganisationEntity organisationEntity = organisationEntityService.getOrganisationByIdUser(usersEntity);
            WalletEntity walletEntity = organisationEntity.getWalletByIdWallet();
            return new OrganisationRegistration(usersEntity.getIdUsers(),
                    usersEntity.getLogin(),
                    usersEntity.getPassword(),
                    usersEntity.getRole(),
                    organisationEntity.getIdOrganisation(),
                    organisationEntity.getName(),
                    organisationEntity.geteMail(),
                    organisationEntity.getLinkOfSite(),
                    organisationEntity.getPhone(),
                    walletEntity.getIdWallet(),
                    walletEntity.getBalance(),
                    walletEntity.getWalletStatus());
        } else {
            CustomerEntity customerEntity = customerEntityService.getCustomerEntityByUsersByIdUsers(usersEntity);
            WalletEntity walletEntity = customerEntity.getWalletByIdWallet();
            return new CustomerRegistration(usersEntity.getIdUsers(),
                    usersEntity.getLogin(),
                    usersEntity.getPassword(),
                    usersEntity.getRole(),
                    customerEntity.getIdCustomer(),
                    customerEntity.getName(),
                    customerEntity.getSurname(),
                    customerEntity.geteMail(),
                    walletEntity.getIdWallet(),
                    walletEntity.getBalance(),
                    walletEntity.getWalletStatus());
        }
    }
}
