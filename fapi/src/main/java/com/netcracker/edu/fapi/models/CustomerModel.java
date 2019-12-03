package com.netcracker.edu.fapi.models;

public class CustomerModel {
    private int idCustomer;
    private String name;
    private String surname;
    private String eMail;
    private String lastVisitDate;
    private int idWallet;
    private int idUser;

    public CustomerModel() {
    }

    public CustomerModel(int idCustomer, String name, String surname, String eMail,
                         String lastVisitDate, int idWallet, int idUser) {
        this.eMail = eMail;
        this.idCustomer = idCustomer;
        this.idUser = idUser;
        this.idWallet = idWallet;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getLastVisitDate() {
        return lastVisitDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
