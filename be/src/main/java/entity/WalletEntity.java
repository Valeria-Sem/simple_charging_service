package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "wallet", schema = "charging_service", catalog = "")
public class WalletEntity {
    private int idWallet;
    private int balance;
    private Object walletStatus;
    private Collection<CustomerEntity> customersByIdWallet;
    private Collection<OrganisationEntity> organisationsByIdWallet;

    @Id
    @Column(name = "id_wallet")
    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    @Basic
    @Column(name = "balance")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "wallet_status")
    public Object getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(Object walletStatus) {
        this.walletStatus = walletStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletEntity that = (WalletEntity) o;
        return idWallet == that.idWallet &&
                balance == that.balance &&
                Objects.equals(walletStatus, that.walletStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWallet, balance, walletStatus);
    }

    @OneToMany(mappedBy = "walletByIdWallet")
    public Collection<CustomerEntity> getCustomersByIdWallet() {
        return customersByIdWallet;
    }

    public void setCustomersByIdWallet(Collection<CustomerEntity> customersByIdWallet) {
        this.customersByIdWallet = customersByIdWallet;
    }

    @OneToMany(mappedBy = "walletByIdWallet")
    public Collection<OrganisationEntity> getOrganisationsByIdWallet() {
        return organisationsByIdWallet;
    }

    public void setOrganisationsByIdWallet(Collection<OrganisationEntity> organisationsByIdWallet) {
        this.organisationsByIdWallet = organisationsByIdWallet;
    }
}
