package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CategoryViewModel;
import com.netcracker.edu.fapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    @Override
    public List<CategoryViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        CategoryViewModel[] categoryViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/category/", CategoryViewModel[].class);
        return categoryViewModelResponse == null? Collections.emptyList() : Arrays.asList(categoryViewModelResponse);
    //categoryViewModelResponse == null? что это значит // CategoryViewModel.class
    }

    @Override
    public CategoryViewModel getCategoryById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/category/" + id, CategoryViewModel.class);
    }

    @Override
    public CategoryViewModel saveCategory(CategoryViewModel category) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/category", category, CategoryViewModel.class).getBody();
    }

    @Override
    public void deleteCategory(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/category" + id);
    }
}
