package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Product;
import com.netcracker.edu.fapi.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<Product> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Product[] productResponse = restTemplate.getForObject(backendServerUrl + "/api/product", Product[].class);
        return productResponse == null? Collections.emptyList() : Arrays.asList(productResponse);
    }

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/product/" + id, Product.class);
    }

    @Override
    public Product saveProduct(Product product) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/product", product, Product.class).getBody();
    }

    @Override
    public void deleteProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/product" + id);
    }
}
