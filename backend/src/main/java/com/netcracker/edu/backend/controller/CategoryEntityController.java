package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.CategoryEntity;
import com.netcracker.edu.backend.service.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryEntityController {

    private CategoryEntityService categoryEntityService;

    @Autowired
    public CategoryEntityController(CategoryEntityService categoryEntityService) {
        this.categoryEntityService = categoryEntityService;
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable(name = "id") Integer id) {
        Optional<CategoryEntity> category = categoryEntityService.getCategoryById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCategoryEntity(@PathVariable(name = "id") Integer id) {
        categoryEntityService.deleteCategory(id);
    }
}
