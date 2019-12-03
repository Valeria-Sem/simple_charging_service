package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletModel {
    private int idWallet;
    private int balance;
    private String walletStatus;

    public WalletModel() {
    }

    public WalletModel(int idWallet, int balance, String walletStatus){
        this.idWallet = idWallet;
        this.balance = balance;
        this.walletStatus = walletStatus;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(String walletStatus) {
        this.walletStatus = walletStatus;
    }
}
