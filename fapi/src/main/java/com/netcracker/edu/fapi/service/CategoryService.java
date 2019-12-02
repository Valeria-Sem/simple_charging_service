package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> getAll();
    CategoryModel getCategoryById(Long id);
   // CategoryViewModel getAllCategory(String category[]);
    CategoryModel saveCategory(CategoryModel category);
    void deleteCategory(Long id);
}
