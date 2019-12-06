package com.netcracker.edu.fapi.models;

import com.netcracker.edu.fapi.models.enums.Role;
import com.netcracker.edu.fapi.models.enums.WalletStatus;

public class CustomerRegistrationModel {
    private int idUser;
    private String login;
    private String password;
    private Role role;

    private int idCustomer;
    private String name;
    private String surname;
    private String eMail;
    private String lastVisitDate;

    private int idWallet;
    private int balance;
    private WalletStatus walletStatus;

    public CustomerRegistrationModel() {
    }

    public CustomerRegistrationModel(int idUser, String login, String password, Role role, int idCustomer, String name, String surname, String eMail,
                                     String lastVisitDate, int idWallet, int balance, WalletStatus walletStatus) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
        this.idWallet = idWallet;
        this.balance = balance;
        this.walletStatus = walletStatus;
        this.eMail = eMail;
        this.idCustomer = idCustomer;
        this.lastVisitDate=lastVisitDate;
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

    public String getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
