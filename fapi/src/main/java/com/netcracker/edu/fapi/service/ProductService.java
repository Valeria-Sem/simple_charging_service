package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Product;

import java.util.List;

public interface ProductService {
        List<Product> getAll();
        Product getProductById(Long id);
        Product[] getProductByIdCategory(Long idCategory);
        Product saveProduct(Product product);
        void deleteProduct(Long id);
}
