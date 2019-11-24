package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ProductEntity;

import java.util.Optional;

public interface ProductEntityService {

    ProductEntity saveProduct(ProductEntity product);
    Optional<ProductEntity> getProductById(Integer id);
    ProductEntity getProductByCategory(Integer idCategory);
    Iterable<ProductEntity> getAllProducts();
    void deleteProduct(Integer id);
}
