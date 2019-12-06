package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CustomerEntity;
import com.netcracker.edu.backend.entity.UsersEntity;
import com.netcracker.edu.backend.entity.WalletEntity;
import com.netcracker.edu.backend.service.CustomerEntityService;
import com.netcracker.edu.backend.service.CustomerRegistrationService;
import com.netcracker.edu.backend.service.UsersEntityService;
import com.netcracker.edu.backend.service.WalletEntityService;
import com.netcracker.edu.backend.transferOfObjects.CustomerRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
    private CustomerEntityService customerEntityService;

    @Autowired
    public void setCustomerEntityService(CustomerEntityService customerEntityService) {
        this.customerEntityService = customerEntityService;
    }

    private WalletEntityService walletEntityService;

    @Autowired
    public void setWalletEntityService(WalletEntityService walletEntityService) {
        this.walletEntityService = walletEntityService;
    }

    private UsersEntityService usersEntityService;

    @Autowired
    public void setUsersEntityService(UsersEntityService usersEntityService) {
        this.usersEntityService = usersEntityService;
    }

    @Override
    public CustomerRegistration registerCustomer(CustomerRegistration registration) {
        WalletEntity wallet = saveNewWallet(registration);
        UsersEntity user = saveNewUser(registration);
        CustomerEntity customerEntity = saveNewCustomer(registration, user, wallet );

        CustomerRegistration customerRegistration = new CustomerRegistration();
        customerRegistration.setIdUser(user.getIdUsers());
        customerRegistration.setIdWallet(wallet.getIdWallet());
        return customerRegistration;

    }

    private WalletEntity saveNewWallet(CustomerRegistration info){
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setBalance(info.getBalance());
        walletEntity.setWalletStatus(info.getWalletStatus());
        return walletEntity;
    }

    private UsersEntity saveNewUser(CustomerRegistration info){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setLogin(info.getLogin());
        usersEntity.setPassword(info.getPassword());
        usersEntity.setRole(info.getRole());
        return usersEntity;
    }

    private CustomerEntity saveNewCustomer(CustomerRegistration info, UsersEntity user, WalletEntity wallet){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(info.getName());
        customerEntity.setSurname(info.getSurname());
        customerEntity.seteMail(info.geteMail());
        customerEntity.setUsersByIdUsers(user);
        customerEntity.setWalletByIdWallet(wallet);
        return customerEntityService.saveCustomer(customerEntity);
    }

}
