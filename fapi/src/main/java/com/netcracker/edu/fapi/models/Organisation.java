package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Organisation {

    private int idOrganisation;
    private String name;
    private String eMail;
    private String linkOfSite;
    private String phone;

    public Organisation(){
    }

    public Organisation(int idOrganisation, String name, String eMail, String linkOfSite, String phone){
        this.idOrganisation = idOrganisation;
        this.name = name;
        this.eMail = eMail;
        this.linkOfSite = linkOfSite;
        this.phone = phone;
    }

    public int getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(int idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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
