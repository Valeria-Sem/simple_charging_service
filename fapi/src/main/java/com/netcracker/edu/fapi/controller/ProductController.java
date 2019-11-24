package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Product;
import com.netcracker.edu.fapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> saveProduct (@RequestBody Product product){
        if(product != null) {
            return ResponseEntity.ok(productService.saveProduct(product));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(Long.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) throws InterruptedException {
        Long productId = Long.valueOf(id);
        return ResponseEntity.ok(productService.getProductById(productId));
    }
}
