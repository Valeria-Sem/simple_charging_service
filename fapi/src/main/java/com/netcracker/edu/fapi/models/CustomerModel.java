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
}
