package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CategoryEntity;

import java.util.Optional;

public interface CategoryEntityService {

    CategoryEntity saveCategory(CategoryEntity category);
    Optional<CategoryEntity> getCategoryById(Integer id);
    Iterable<CategoryEntity> getAllCategory();
    void deleteCategory(Integer id);
}
