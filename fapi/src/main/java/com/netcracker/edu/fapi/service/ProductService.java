package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.PageProductModel;
import com.netcracker.edu.fapi.models.ProductModel;

import java.util.List;

public interface ProductService {
        List<ProductModel> getAll();
        ProductModel getProductById(Long id);
        PageProductModel getProductByCategory(int idCategory, int pageNum, int pageSize);
        PageProductModel getProductByOrganisation(int idOrganisation, int pageNum, int pageSize);
        ProductModel saveProduct(ProductModel product);
        void deleteProduct(Long id);
}
