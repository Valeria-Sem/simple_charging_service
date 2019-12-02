package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CategoryModel;
import com.netcracker.edu.fapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<CategoryModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        CategoryModel[] categoryModelResponse = restTemplate.getForObject(backendServerUrl + "/api/category/", CategoryModel[].class);
        return categoryModelResponse == null? Collections.emptyList() : Arrays.asList(categoryModelResponse);
    }

    @Override
    public CategoryModel getCategoryById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/category/" + id, CategoryModel.class);
    }

//    @Override
//    public CategoryViewModel getAllCategory(String[] category) {
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(backendServerUrl + "/api/category/" + category, CategoryViewModel.class);
//    }

    @Override
    public CategoryModel saveCategory(CategoryModel category) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/category", category, CategoryModel.class).getBody();
    }

    @Override
    public void deleteCategory(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/category" + id);
    }
}
