package com.netcracker.edu.backend.transferOfObjects;

import com.netcracker.edu.backend.entity.WalletEntity;
import com.netcracker.edu.backend.entity.enums.UsersRole;
import com.netcracker.edu.backend.entity.enums.WalletStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CustomerRegistration extends AbstractRegistrationModel{
    private int idCustomer;
    private String name;
    private String surname;
    private String eMail;

    public CustomerRegistration() {
    }

    public CustomerRegistration(int idUser, String login, String password,UsersRole role,
                                int idCustomer, String name, String surname, String eMail,
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
