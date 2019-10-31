package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "subscription", schema = "charging_service", catalog = "")
public class SubscriptionEntity {
    private int idSubscription;
    private Object subscriptionStatus;
    private Date dateOfSubscription;
    private CustomerEntity customerByIdCustomers;
    private ProductEntity productByIdProduct;

    @Id
    @Column(name = "id_subscription")
    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    @Basic
    @Column(name = "subscription_status")
    public Object getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(Object subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    @Basic
    @Column(name = "date_of_subscription")
    public Date getDateOfSubscription() {
        return dateOfSubscription;
    }

    public void setDateOfSubscription(Date dateOfSubscription) {
        this.dateOfSubscription = dateOfSubscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionEntity that = (SubscriptionEntity) o;
        return idSubscription == that.idSubscription &&
                Objects.equals(subscriptionStatus, that.subscriptionStatus) &&
                Objects.equals(dateOfSubscription, that.dateOfSubscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubscription, subscriptionStatus, dateOfSubscription);
    }

    @ManyToOne
    @JoinColumn(name = "id_customers", referencedColumnName = "id_customer", nullable = false)
    public CustomerEntity getCustomerByIdCustomers() {
        return customerByIdCustomers;
    }

    public void setCustomerByIdCustomers(CustomerEntity customerByIdCustomers) {
        this.customerByIdCustomers = customerByIdCustomers;
    }

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false)
    public ProductEntity getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(ProductEntity productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }
}
