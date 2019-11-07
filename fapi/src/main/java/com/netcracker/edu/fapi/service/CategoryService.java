package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CategoryViewModel;

import java.util.List;

public interface CategoryService {
    List<CategoryViewModel> getAll();
    CategoryViewModel getCategoryById(Long id);
    CategoryViewModel saveCategory(CategoryViewModel category);
    void deleteCategory(Long id);
}
