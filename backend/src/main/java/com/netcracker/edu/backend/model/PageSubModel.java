package com.netcracker.edu.backend.model;

import com.netcracker.edu.backend.transferOfObjects.CustomerProductModel;

import java.util.List;

public class PageSubModel {
    private int countOfElements;
    private List<CustomerProductModel> customerProductModels;

    public PageSubModel(){
    }

    public PageSubModel(int countOfElements, List<CustomerProductModel> customerProductModels){
        this.countOfElements = countOfElements;
        this.customerProductModels = customerProductModels;
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
