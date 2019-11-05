package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CategoryEntity;

import java.util.Optional;

public interface CaregoryEntitySevice {

    CategoryEntity saveCategory(CategoryEntity category);
    Optional<CategoryEntity> getCategoryById(Long id);
   // Interable<CategoryEntity> getAll
}
