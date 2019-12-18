package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ProductModel;

import java.util.List;

public interface ProductService {
        List<ProductModel> getAll();
        ProductModel getProductById(Long id);
        ProductModel[] getProductByIdCategory(Long idCategory);
        ProductModel[] getProductByIdOrganisation(Long IdOrganisation);
        ProductModel saveProduct(ProductModel product);
        void deleteProduct(Long id);
}
