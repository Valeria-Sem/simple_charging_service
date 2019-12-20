package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;

import java.util.List;
import java.util.Optional;

public interface ProductEntityService {

    ProductEntity saveProduct(ProductEntity product);
    ProductEntity getProductById(Integer id);
    ProductEntity[] getProductByCategory(Integer idCategory);
    ProductEntity[] getProductByOrganisation(Integer idOrganisation);
    Iterable<ProductEntity> getAllProducts();
//    List<ProductEntity> getAll();
    void deleteProduct(Integer id);
}
