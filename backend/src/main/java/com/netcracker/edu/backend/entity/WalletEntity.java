package com.netcracker.edu.backend.entity;

import com.netcracker.edu.backend.entity.enums.WalletStatus;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "wallet", schema = "charging_service", catalog = "")
public class WalletEntity {
    private int idWallet;
    private int balance;
    private WalletStatus walletStatus;

    @Id
    @Column(name = "id_wallet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    @Column(name = "wallet_status")
    public WalletStatus getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(WalletStatus walletStatus) {
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
}
