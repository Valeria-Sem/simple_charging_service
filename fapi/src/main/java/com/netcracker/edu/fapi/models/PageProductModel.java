package com.netcracker.edu.fapi.models;

import java.util.List;

public class PageProductModel {
    private int countOfElements;
    private List<ProductModel> productEntities;

    public PageProductModel(){
    }

    public PageProductModel(int countOfElements, List<ProductModel> productEntities){
        this.countOfElements = countOfElements;
        this.productEntities = productEntities;
    }



    public List<ProductModel> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(List<ProductModel> productEntities) {
        this.productEntities = productEntities;
    }

    public int getCountOfElements() {
        return countOfElements;
    }

    public void setCountOfElements(int countOfElements) {
        this.countOfElements = countOfElements;
    }
}
