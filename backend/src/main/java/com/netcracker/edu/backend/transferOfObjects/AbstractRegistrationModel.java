package com.netcracker.edu.backend.transferOfObjects;

import com.netcracker.edu.backend.entity.enums.UsersRole;
import com.netcracker.edu.backend.entity.enums.WalletStatus;

public abstract class AbstractRegistrationModel {
    private int idUser;
    private String login;
    private String password;
    private UsersRole role;

    private int idWallet;
    private int balance;
    private WalletStatus walletStatus;

    public AbstractRegistrationModel() {
    }

    public AbstractRegistrationModel(int idUser, String login, String password,UsersRole role,
                                     int idWallet, int balance, WalletStatus walletStatus) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
        this.idWallet = idWallet;
        this.balance = balance;
        this.walletStatus = walletStatus;

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersRole getRole() {
        return role;
    }

    public void setRole(UsersRole role) {
        this.role = role;
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

    public WalletStatus getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(WalletStatus walletStatus) {
        this.walletStatus = walletStatus;
    }
}
