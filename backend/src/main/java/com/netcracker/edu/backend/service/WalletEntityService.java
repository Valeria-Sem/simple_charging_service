package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.WalletEntity;

import java.util.Optional;

public interface WalletEntityService {
    WalletEntity saveWallet(WalletEntity wallet);
    Optional<WalletEntity> getWalletById(Integer id);
    Iterable<WalletEntity> getAllWallets();
    void deleteWallet(Integer id);
}
