package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.entity.SubscriptionEntity;
import com.netcracker.edu.backend.model.PageProductModel;
import com.netcracker.edu.backend.repository.ProductEntityRepository;
import com.netcracker.edu.backend.service.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
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

//    @Override
//    public ProductEntity getProduct(SubscriptionEntity subscriptionEntity) {
//        return repository.getProduct(subscriptionEntity);
//    }

    @Override
    public ProductEntity getProductById(Integer id) {
        return repository.getProductByIdProduct(id);
    }

    @Override
    public PageProductModel getProductByCategory(int idCategory, int pageNum, int pageSize) {
        Pageable pageable =  PageRequest.of( pageNum, pageSize, Sort.by("name"));
        Page<ProductEntity> page = repository.findByIdCategory(idCategory, pageable);
        return new PageProductModel((int)page.getTotalElements(), page.getContent());
    }

    @Override
    public PageProductModel getProductByOrganisation(int idOrganisation, int pageNum, int pageSize) {
        Pageable pageable =  PageRequest.of( pageNum, pageSize, Sort.by("name"));
        Page<ProductEntity> page = repository.findByIdOrganisation(idOrganisation, pageable);
        return new PageProductModel((int)page.getTotalElements(), page.getContent());
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
