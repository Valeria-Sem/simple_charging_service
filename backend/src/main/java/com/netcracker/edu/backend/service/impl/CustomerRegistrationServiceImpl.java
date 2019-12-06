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

//    @Autowired
//    private CustomerRegistrationServiceImpl(CustomerEntityService customerEntityService){}


    @Override
    public CustomerRegistration registrateCustomer(CustomerRegistration registration) {
        WalletEntity walletEntity = saveNewWallet(registration);

        UsersEntity usersEntity = usersEntityService.save(registration);

        CustomerEntity customerEntity = customerEntityService.saveCustomer(registration);
        CustomerRegistration customerRegistration = new CustomerRegistration();
        customerRegistration.

    }

    private WalletEntity saveNewWallet(CustomerRegistration info){
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setBalance(info.getBalance());
        new WalletEntity.WalletStatus(info.getWalletStatus())
        walletEntity.setWalletStatus(info.getWalletStatus());
        walletEntityService.saveWallet(walletEntity);
        return walletEntity;
    }



}
