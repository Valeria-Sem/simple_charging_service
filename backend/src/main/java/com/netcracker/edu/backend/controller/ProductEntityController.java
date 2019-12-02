package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.ProductEntity;
import com.netcracker.edu.backend.service.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductEntityController {

    private ProductEntityService productEntityService;

    @Autowired
    public ProductEntityController(ProductEntityService productEntityService) {
        this.productEntityService = productEntityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ProductEntity> getAllProducts() {
        return productEntityService.getAllProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductEntity> getProductById(@PathVariable(name ="id") Integer id) {
        Optional<ProductEntity> product = productEntityService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity){
        return productEntityService.saveProduct(productEntity);
    }

    @RequestMapping(value = "/category/{idCategory}", method = RequestMethod.GET)
    public ResponseEntity<ProductEntity[]> getProductByCategory(@PathVariable(name = "idCategory") int idCategory) {
        ProductEntity[] products = productEntityService.getProductByCategory(idCategory);
        return ResponseEntity.ok(products);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProductEntity(@PathVariable(name = "id") Integer id) {
        productEntityService.deleteProduct(id);
    }
}
