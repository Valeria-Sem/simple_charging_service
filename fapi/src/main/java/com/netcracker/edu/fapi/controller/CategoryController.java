package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CategoryViewModel;
import com.netcracker.edu.fapi.service.CategoryService;
//import com.sun.deploy.util.SyncAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping
    public ResponseEntity<List<CategoryViewModel>> getAllCategories(){
       return ResponseEntity.ok(categoryService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CategoryViewModel> saveCategory(@RequestBody CategoryViewModel category /*todo server validation*/) {
        if(category != null) {
            return ResponseEntity.ok(categoryService.saveCategory(category));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable String id) { // почему String
        categoryService.deleteCategory(Long.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<CategoryViewModel> getAllCategories(@PathVariable String id) throws InterruptedException {
        Long categoryId = Long.valueOf(id);
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }
}
