package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {
    ProductEntity[]findByIdCategory(int idCategory);
}
