package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "organisation", schema = "charging_service", catalog = "")
public class OrganisationEntity {
    private int idOrganisation;
    private int idUsers;
    private int idWallet;
    private String name;
    private String eMail;
    private String linkOfSite;
    private String phone;
    private UsersEntity usersByIdUsers;
    private WalletEntity walletByIdWallet;
    private Collection<ProductEntity> productsByIdOrganisation;

    @Id
    @Column(name = "id_organisation")
    public int getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(int idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    @Basic
    @Column(name = "id_users")
    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "id_wallet")
    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "e-mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "link_of_site")
    public String getLinkOfSite() {
        return linkOfSite;
    }

    public void setLinkOfSite(String linkOfSite) {
        this.linkOfSite = linkOfSite;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganisationEntity that = (OrganisationEntity) o;
        return idOrganisation == that.idOrganisation &&
                idUsers == that.idUsers &&
                idWallet == that.idWallet &&
                Objects.equals(name, that.name) &&
                Objects.equals(eMail, that.eMail) &&
                Objects.equals(linkOfSite, that.linkOfSite) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrganisation, idUsers, idWallet, name, eMail, linkOfSite, phone);
    }

    @ManyToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", nullable = false)
    public UsersEntity getUsersByIdUsers() {
        return usersByIdUsers;
    }

    public void setUsersByIdUsers(UsersEntity usersByIdUsers) {
        this.usersByIdUsers = usersByIdUsers;
    }

    @ManyToOne
    @JoinColumn(name = "id_wallet", referencedColumnName = "id_wallet", nullable = false)
    public WalletEntity getWalletByIdWallet() {
        return walletByIdWallet;
    }

    public void setWalletByIdWallet(WalletEntity walletByIdWallet) {
        this.walletByIdWallet = walletByIdWallet;
    }

    @OneToMany(mappedBy = "organisationByIdOrganisation")
    public Collection<ProductEntity> getProductsByIdOrganisation() {
        return productsByIdOrganisation;
    }

    public void setProductsByIdOrganisation(Collection<ProductEntity> productsByIdOrganisation) {
        this.productsByIdOrganisation = productsByIdOrganisation;
    }
}
