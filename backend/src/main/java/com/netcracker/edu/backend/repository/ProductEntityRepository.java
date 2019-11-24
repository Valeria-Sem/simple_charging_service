package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {
}
