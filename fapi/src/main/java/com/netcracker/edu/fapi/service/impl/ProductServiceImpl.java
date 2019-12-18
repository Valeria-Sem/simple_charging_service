package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.ProductModel;
import com.netcracker.edu.fapi.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("http://localhost:8080")
    private String backendServerUrl;

    @Override
    public List<ProductModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ProductModel[] productResponse = restTemplate.getForObject(backendServerUrl + "/api/product", ProductModel[].class);
        return productResponse == null? Collections.emptyList() : Arrays.asList(productResponse);
    }

    @Override
    public ProductModel getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/product/" + id, ProductModel.class);
    }

    @Override
    public ProductModel[] getProductByIdCategory(Long idCategory) {
        RestTemplate restTemplate = new RestTemplate();
        ProductModel[] products = restTemplate.getForObject(backendServerUrl + "/api/product/category/" + idCategory, ProductModel[].class);
        return products;
    }

    @Override
    public ProductModel[] getProductByIdOrganisation(Long IdOrganisation) {
        RestTemplate restTemplate = new RestTemplate();
        ProductModel[] products = restTemplate.getForObject(backendServerUrl + "/api/product/organisation/" + IdOrganisation, ProductModel[].class);
        return products;
    }

    @Override
    public ProductModel saveProduct(ProductModel product) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/product", product, ProductModel.class).getBody();
    }

    @Override
    public void deleteProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/product/delete" + id);
    }
}
