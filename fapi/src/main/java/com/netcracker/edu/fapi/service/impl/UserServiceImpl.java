package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public UserViewModel saveUser(UserViewModel user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, UserViewModel.class).getBody();
    }

    @Override
    public UserViewModel findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel user = restTemplate.getForObject(backendServerUrl + "/api/user/login/" + login, UserViewModel.class);
        return user;
    }

    @Override
    public List<UserViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userResponse = restTemplate.getForObject(backendServerUrl + "/api/user", UserViewModel[].class);
        return userResponse == null ? Collections.emptyList() : Arrays.asList(userResponse);
    }

    @Override
    public void deleteUser(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "api/user/" + id);
    }
}
