package com.netcracker.edu.fapi.models;

import com.netcracker.edu.fapi.models.enums.Role;
import com.netcracker.edu.fapi.models.enums.WalletStatus;

public class CustomerRegistrationModel extends AbstractRegModel{
    private int idCustomer;
    private String name;
    private String surname;
    private String eMail;


    public CustomerRegistrationModel() {
    }

    public CustomerRegistrationModel(int idUser, String login, String password, Role role, int idCustomer, String name, String surname, String eMail,
                                      int idWallet, int balance, WalletStatus walletStatus) {
        super(idUser, login, password, role, idWallet, balance, walletStatus);
        this.eMail = eMail;
        this.idCustomer = idCustomer;
        this.name = name;
        this.surname = surname;
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

}
