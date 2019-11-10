package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.CategoryEntity;
import com.netcracker.edu.backend.repository.CategoryEntityRepository;
import com.netcracker.edu.backend.service.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryEntityServiceImpl implements CategoryEntityService {

    private CategoryEntityRepository repository;

    @Autowired
    public CategoryEntityServiceImpl(CategoryEntityRepository repository){
       this.repository = repository;
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity category) {
        return repository.save(category);
    }

    @Override
    public Optional<CategoryEntity> getCategoryById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<CategoryEntity> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public void deleteCategory(Integer id) {
        repository.deleteById(id);
    }
}
