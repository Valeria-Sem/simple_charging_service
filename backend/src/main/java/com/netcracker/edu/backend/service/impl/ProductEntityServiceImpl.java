package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.repository.ProductEntityRepository;
import com.netcracker.edu.backend.service.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductEntityServiceImpl implements ProductEntityService {
    private ProductEntityRepository repository;

    @Autowired
    public ProductEntityServiceImpl(ProductEntityRepository repository){
        this.repository = repository;
    }
    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        return repository.save(product);
    }

    @Override
    public Optional<ProductEntity> getProductById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ProductEntity> getProductByCategory(Integer idCategory) {
        return repository.findById(idCategory);
    }

    @Override
    public Iterable<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteById(id);
    }
}
