package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {
    ProductEntity[]findByIdCategory(int idCategory);
    ProductEntity[]findByIdOrganisation(int IdOrganisation);
    ProductEntity getProductByIdProduct(int idProduct);
    //ProductEntity getProduct (SubscriptionEntity subscriptionEntity);
}
