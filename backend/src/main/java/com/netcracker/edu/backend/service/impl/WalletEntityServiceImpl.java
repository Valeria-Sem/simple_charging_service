package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.WalletEntity;
import com.netcracker.edu.backend.repository.WalletEntityRepository;
import com.netcracker.edu.backend.service.WalletEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletEntityServiceImpl implements WalletEntityService {
    private WalletEntityRepository repository;

    @Autowired
    public WalletEntityServiceImpl(WalletEntityRepository repository){
        this.repository = repository;
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
