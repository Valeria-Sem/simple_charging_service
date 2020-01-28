package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.entity.WalletEntity;
import com.netcracker.edu.backend.repository.WalletEntityRepository;
import com.netcracker.edu.backend.service.OrganisationEntityService;
import com.netcracker.edu.backend.service.WalletEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletEntityServiceImpl implements WalletEntityService {
    private WalletEntityRepository repository;
    private OrganisationEntityService organisationEntityService;

    @Autowired
    public WalletEntityServiceImpl(WalletEntityRepository repository, OrganisationEntityService organisationEntityService){
        this.repository = repository;
        this.organisationEntityService = organisationEntityService;
    }


    @Override
    public WalletEntity saveWallet(WalletEntity wallet) {
        return repository.save(wallet);
    }

    @Override
    public Optional<WalletEntity> getWalletById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public WalletEntity balanceReplenishment(WalletEntity wallet) {
        return repository.save(wallet);
    }

    @Override
    public OrganisationEntity balanceReplenishmentByIdOrg(int idOrg, int balance) {
        OrganisationEntity organisation = organisationEntityService.getOrganisationByIdOrganisation(idOrg);
        WalletEntity walletEntity = organisation.getWalletByIdWallet();
        int newBalance = (int)walletEntity.getBalance() + balance;
        walletEntity.setBalance(newBalance);
        organisation.setWalletByIdWallet(walletEntity);
        return organisationEntityService.saveOrganisation(organisation);
    }

    @Override
    public WalletEntity payment(WalletEntity wallet) {
        return repository.save(wallet);
    }

    @Override
    public Iterable<WalletEntity> getAllWallets() {
        return repository.findAll();
    }


    @Override
    public void deleteWallet(Integer id) {
        repository.deleteById(id);
    }
}
