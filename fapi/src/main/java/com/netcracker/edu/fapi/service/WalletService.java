package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.WalletModel;

import java.util.List;

public interface WalletService {
    List<WalletModel> getAll();
    WalletModel getWalletById(Long id);
    WalletModel saveWallet(WalletModel wallet);
    WalletModel payment(WalletModel wallet);
    WalletModel balanceReplenishment(WalletModel wallet);
    void deleteWallet(Long id);
}
