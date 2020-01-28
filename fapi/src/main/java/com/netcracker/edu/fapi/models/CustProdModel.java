package com.netcracker.edu.fapi.models;

import com.netcracker.edu.fapi.models.enums.SubStatus;

public class CustProdModel {
        private int idSubscription;
        private String name;
        private String description;
        private int monthPrise;
        private String img;
        private SubStatus subscriptionStatus;

        public CustProdModel(){
        }

        public CustProdModel(  int idSubscription, String name,
                               String description, int monthPrise,
                               String img, SubStatus subscriptionStatus){
            this.idSubscription = idSubscription;
            this.name = name;
            this.description = description;
            this.monthPrise = monthPrise;
            this.img = img;
            this.subscriptionStatus = subscriptionStatus;
        }


        public int getIdSubscription() {
            return idSubscription;
        }

        public void setIdSubscription(int idSubscription) {
            this.idSubscription = idSubscription;
        }

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

    public SubStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(SubStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }
}
