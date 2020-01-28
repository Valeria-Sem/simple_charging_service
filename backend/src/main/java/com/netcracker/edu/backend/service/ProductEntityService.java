package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.model.PageProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductEntityService {

    ProductEntity saveProduct(ProductEntity product);
    ProductEntity getProductById(Integer id);
    PageProductModel getProductByCategory(int idCategory, int pageNum, int pageSize);
    PageProductModel getProductByOrganisation(int idOrganisation, int pageNum, int pageSize);
    Iterable<ProductEntity> getAllProducts();
//    List<ProductEntity> getAll();
    void deleteProduct(Integer id);
}
