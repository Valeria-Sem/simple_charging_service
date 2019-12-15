package com.netcracker.edu.backend.transferOfObjects;

import com.netcracker.edu.backend.entity.WalletEntity;
import com.netcracker.edu.backend.entity.enums.UsersRole;
import com.netcracker.edu.backend.entity.enums.WalletStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CustomerRegistration {
    private int idUser;
    private String login;
    private String password;
    private UsersRole role;

    private int idCustomer;
    private String name;
    private String surname;
    private String eMail;

    private int idWallet;
    private int balance;
    private WalletStatus walletStatus;

    public CustomerRegistration() {
    }

    public CustomerRegistration(int idUser, String login, String password, UsersRole role, int idCustomer, String name, String surname, String eMail,
                                 int idWallet, int balance, WalletStatus walletStatus) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
        this.idWallet = idWallet;
        this.balance = balance;
        this.walletStatus = walletStatus;
        this.eMail = eMail;
        this.idCustomer = idCustomer;
        this.name = name;
        this.surname = surname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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



}
