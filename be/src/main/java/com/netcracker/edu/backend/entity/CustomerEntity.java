package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "charging_service", catalog = "")
public class CustomerEntity {
    private int idCustomer;
    private String name;
    private String surname;
    private String eMail;
    private Date lastVisitDate;
    private int idWallet;
    private int idUsers;
    private WalletEntity walletByIdWallet;
    private UsersEntity usersByIdUsers;
    private Collection<SubscriptionEntity> subscriptionsByIdCustomer;

    @Id
    @Column(name = "id_customer")
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
    @Column(name = "last_visit_date")
    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
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
    @Column(name = "id_users")
    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return idCustomer == that.idCustomer &&
                idWallet == that.idWallet &&
                idUsers == that.idUsers &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(eMail, that.eMail) &&
                Objects.equals(lastVisitDate, that.lastVisitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, name, surname, eMail, lastVisitDate, idWallet, idUsers);
    }

    @ManyToOne
    @JoinColumn(name = "id_wallet", referencedColumnName = "id_wallet", nullable = false)
    public WalletEntity getWalletByIdWallet() {
        return walletByIdWallet;
    }

    public void setWalletByIdWallet(WalletEntity walletByIdWallet) {
        this.walletByIdWallet = walletByIdWallet;
    }

    @ManyToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", nullable = false)
    public UsersEntity getUsersByIdUsers() {
        return usersByIdUsers;
    }

    public void setUsersByIdUsers(UsersEntity usersByIdUsers) {
        this.usersByIdUsers = usersByIdUsers;
    }

    @OneToMany(mappedBy = "customerByIdCustomers")
    public Collection<SubscriptionEntity> getSubscriptionsByIdCustomer() {
        return subscriptionsByIdCustomer;
    }

    public void setSubscriptionsByIdCustomer(Collection<SubscriptionEntity> subscriptionsByIdCustomer) {
        this.subscriptionsByIdCustomer = subscriptionsByIdCustomer;
    }
}
