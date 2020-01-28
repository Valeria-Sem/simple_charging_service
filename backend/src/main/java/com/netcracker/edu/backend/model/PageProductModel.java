package com.netcracker.edu.backend.model;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.transferOfObjects.CustomerProductModel;

import java.util.List;

public class PageProductModel {
    private int countOfElements;
    private List<ProductEntity> productEntities;
    private List<CustomerProductModel> customerProductModels;

    public PageProductModel(){
    }

    public PageProductModel(int countOfElements, List<ProductEntity> productEntities){
        this.countOfElements = countOfElements;
        this.productEntities = productEntities;
    }




    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    public int getCountOfElements() {
        return countOfElements;
    }

    public void setCountOfElements(int countOfElements) {
        this.countOfElements = countOfElements;
    }

    public List<CustomerProductModel> getCustomerProductModels() {
        return customerProductModels;
    }

    public void setCustomerProductModels(List<CustomerProductModel> customerProductModels) {
        this.customerProductModels = customerProductModels;
    }
}
