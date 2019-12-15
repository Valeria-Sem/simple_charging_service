package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.entity.WalletEntity;
import com.netcracker.edu.backend.service.OrganisationEntityService;
import com.netcracker.edu.backend.service.OrganisationRegistrationService;
import com.netcracker.edu.backend.service.UsersEntityService;
import com.netcracker.edu.backend.service.WalletEntityService;
import com.netcracker.edu.backend.transferOfObjects.OrganisationRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganisationRegistrationServiceImpl implements OrganisationRegistrationService {
    private OrganisationEntityService organisationEntityService;
    private WalletEntityService walletEntityService;
    private UsersEntityService usersEntityService;

    @Autowired
    public OrganisationRegistrationServiceImpl(OrganisationEntityService organisationEntityService, WalletEntityService walletEntityService, UsersEntityService usersEntityService) {
        this.organisationEntityService = organisationEntityService;
        this.walletEntityService = walletEntityService;
        this.usersEntityService = usersEntityService;
    }


    @Override
    public OrganisationRegistration registerOrganisation(OrganisationRegistration registration) {
        WalletEntity wallet = saveNewWallet(registration);
        UsersEntity user = saveNewUser(registration);
        saveNewOrganisation(registration, user, wallet );

        OrganisationRegistration organisationRegistration = new OrganisationRegistration();
        organisationRegistration.setIdUser(user.getIdUsers());
        organisationRegistration.setIdWallet(wallet.getIdWallet());
        return organisationRegistration;
    }

    private WalletEntity saveNewWallet(OrganisationRegistration info){
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setBalance(info.getBalance());
        walletEntity.setWalletStatus(info.getWalletStatus());
        return walletEntity;
    }

    private UsersEntity saveNewUser(OrganisationRegistration info){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setLogin(info.getLogin());
        usersEntity.setPassword(info.getPassword());
        usersEntity.setRole(info.getRole());
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

    @Override
    public OrganisationRegistration getOrganisationProfileInformation(String log, String pas) {
        UsersEntity usersEntity = usersEntityService.getUserIdByLoginAndPassword(log, pas);
        OrganisationEntity organisationEntity = organisationEntityService.getOrganisationByIdUser(usersEntity);    //usersEntity.getIdUsers
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
    }
}
