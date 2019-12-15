package com.netcracker.edu.backend.transferOfObjects;

import com.netcracker.edu.backend.entity.enums.UsersRole;
import com.netcracker.edu.backend.entity.enums.WalletStatus;

public class OrganisationRegistration {
    private int idUser;
    private String login;
    private String password;
    private UsersRole role;

    private int idOrganisation;
    private String name;
    private String eMail;
    private String linkOfSite;
    private String phone;

    private int idWallet;
    private int balance;
    private WalletStatus walletStatus;

    public OrganisationRegistration() {
    }

    public OrganisationRegistration(int idUser, String login, String password, UsersRole role, int idOrganisation, String name, String eMail,
                                 String linkOfSite, String phone, int idWallet, int balance, WalletStatus walletStatus) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
        this.idWallet = idWallet;
        this.balance = balance;
        this.walletStatus = walletStatus;
        this.eMail = eMail;
        this.idOrganisation = idOrganisation;
        this.name = name;
        this.linkOfSite = linkOfSite;
        this.phone = phone;
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

    public int getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(int idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

    public String getLinkOfSite() {
        return linkOfSite;
    }

    public void setLinkOfSite(String linkOfSite) {
        this.linkOfSite = linkOfSite;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
