package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.entity.WalletEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface WalletEntityService {
    WalletEntity saveWallet(WalletEntity wallet);
    Optional<WalletEntity> getWalletById(Integer id);
    WalletEntity balanceReplenishment(WalletEntity wallet);
    OrganisationEntity balanceReplenishmentByIdOrg(int idOrg, int balance);
    WalletEntity payment (WalletEntity wallet);
    Iterable<WalletEntity> getAllWallets();
    void deleteWallet(Integer id);
}
