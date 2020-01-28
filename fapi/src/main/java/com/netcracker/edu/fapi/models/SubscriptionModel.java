package com.netcracker.edu.fapi.models;

import com.netcracker.edu.fapi.models.enums.SubStatus;

import java.sql.Date;

public class SubscriptionModel {
    private int idSubscription;
    private int IdCustomers;
    private int IdProduct;
    private SubStatus subscriptionStatus;
    private Date dateOfSubscription;

    public SubscriptionModel(){
    }

    public SubscriptionModel(int idSubscription, int IdCustomers, int IdProduct
                            ,SubStatus subscriptionStatus, Date dateOfSubscription){
        this.idSubscription = idSubscription;
        this.IdCustomers = IdCustomers;
        this.IdProduct = IdProduct;
        this.subscriptionStatus = subscriptionStatus;
        this.dateOfSubscription = dateOfSubscription;
    }

    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public int getIdCustomers() {
        return IdCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        IdCustomers = idCustomers;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
    }

    public SubStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(SubStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public Date getDateOfSubscription() {
        return dateOfSubscription;
    }

    public void setDateOfSubscription(Date dateOfSubscription) {
        this.dateOfSubscription = dateOfSubscription;
    }
}
