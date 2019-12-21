package com.netcracker.edu.backend.transferOfObjects;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;

public class CustomerProductModel {
    private int idSubscription;
//    private int idCustomer;
//    private int idProduct;
    private String name;
    private String description;
    private int monthPrise;
    private String img;

    public CustomerProductModel(){
    }

    public CustomerProductModel(  int idSubscription, String name,
                                String description, int monthPrise, String img){
        this.idSubscription = idSubscription;
//        this.idCustomer = idCustomer;
//        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.monthPrise = monthPrise;
        this.img = img;
    }


    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

//    public int getIdCustomer() {
//        return idCustomer;
//    }
//
//    public void setIdCustomer(int idCustomer) {
//        this.idCustomer = idCustomer;
//    }
//
//    public int getIdProduct() {
//        return idProduct;
//    }
//
//    public void setIdProduct(int idProduct) {
//        this.idProduct = idProduct;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMonthPrise() {
        return monthPrise;
    }

    public void setMonthPrise(int monthPrise) {
        this.monthPrise = monthPrise;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
