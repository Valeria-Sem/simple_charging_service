package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private int idProduct;
    private int idOrganisation;
    private String name;
    private String description;
    private int monthPrise;
    private int idCategory;

    public Product() {}

    public Product(int idProduct, int idOrganisation, String name, String description, int monthPrise, int idCategory) {
        this.idProduct = idProduct;
        this.idCategory = idOrganisation;
        this.name = name;
        this.description = description;
        this.monthPrise = monthPrise;
        this.idCategory = idCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(int idOrganisation) {
        this.idOrganisation = idOrganisation;
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

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
