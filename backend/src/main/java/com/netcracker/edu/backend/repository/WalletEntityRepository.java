package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletEntityRepository extends CrudRepository<WalletEntity, Integer> {
    WalletEntity getBalanceByIdWallet(WalletEntity wallet);
}
