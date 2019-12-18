package com.netcracker.edu.backend.transferOfObjects;

import com.netcracker.edu.backend.entity.enums.UsersRole;
import com.netcracker.edu.backend.entity.enums.WalletStatus;

public class OrganisationRegistration extends AbstractRegistrationModel{
    private int idOrganisation;
    private String name;
    private String eMail;
    private String linkOfSite;
    private String phone;

    public OrganisationRegistration() {
    }

    public OrganisationRegistration(int idUser, String login, String password,UsersRole role,
                                    int idOrganisation, String name, String eMail,
                                 String linkOfSite, String phone,
                                    int idWallet, int balance, WalletStatus walletStatus) {
        super(idUser, login, password, role, idWallet, balance, walletStatus);
        this.eMail = eMail;
        this.idOrganisation = idOrganisation;
        this.name = name;
        this.linkOfSite = linkOfSite;
        this.phone = phone;
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
}
