package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.ProductModel;
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
    public ResponseEntity<List<ProductModel>> getAllProduct(){
        return ResponseEntity.ok(productService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProductModel> saveProduct (@RequestBody ProductModel product){
        if(product != null) {
            return ResponseEntity.ok(productService.saveProduct(product));
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(Long.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable String id) throws InterruptedException {
        Long productId = Long.valueOf(id);
        return ResponseEntity.ok(productService.getProductById(productId));
    }

//    @RequestMapping(value = "/category/{idCategory}")
//    public ResponseEntity<Product> getProductByIdCategory(@PathVariable String idCategory) throws InterruptedException {
//        Long productIdCategory = Long.valueOf(idCategory);
//        return ResponseEntity.ok(productService.getProductByIdCategory(productIdCategory));
//    }

    @RequestMapping(value = "/category/{idCategory}")
    public ProductModel[] getProductByIdCategory(@PathVariable String idCategory) throws InterruptedException {
        Long productIdCategory = Long.valueOf(idCategory);
        return productService.getProductByIdCategory(productIdCategory);
    }

    @RequestMapping(value = "/organisation/{idOrganisation}")
    public ProductModel[] getProductByIdOrganisation(@PathVariable String idOrganisation) throws InterruptedException {
        Long productIdOrganisation = Long.valueOf(idOrganisation);
        return productService.getProductByIdOrganisation(productIdOrganisation);
    }
}
