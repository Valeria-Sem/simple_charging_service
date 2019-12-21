package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.model.PageProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {
    Page<ProductEntity> findByIdCategory(int idCategory, Pageable pageable);
    Page<ProductEntity> findByIdOrganisation(int IdOrganisation, Pageable pageable);
    ProductEntity getProductByIdProduct(int idProduct);
}
