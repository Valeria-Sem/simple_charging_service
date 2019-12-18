package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;

import java.util.Optional;

public interface ProductEntityService {

    ProductEntity saveProduct(ProductEntity product);
    ProductEntity getProductById(Integer id);
//    ProductEntity getProduct(SubscriptionEntity subscriptionEntity);
    ProductEntity[] getProductByCategory(Integer idCategory);
    ProductEntity[] getProductByOrganisation(Integer idOrganisation);
    Iterable<ProductEntity> getAllProducts();
    void deleteProduct(Integer id);
}
