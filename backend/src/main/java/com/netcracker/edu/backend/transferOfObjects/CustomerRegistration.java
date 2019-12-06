package com.netcracker.edu.backend.transferOfObjects;

public class CustomerRegistration {
    private long idUser;
    private String login;
    private String password;
    private String role;

    private int idCustomer;
    private String name;
    private String surname;
    private String eMail;
    private String lastVisitDate;

    private int idWallet;
    private int balance;
    private String walletStatus;

    public CustomerRegistration() {
    }

    public CustomerRegistration(long idUser, String login, String password, String role, int idCustomer, String name, String surname, String eMail,
                                     String lastVisitDate, int idWallet, int balance, String walletStatus) {
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

    public String getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(String walletStatus) {
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

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
