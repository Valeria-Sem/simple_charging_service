package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserModel saveUser(UserModel user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, UserModel.class).getBody();
    }

    @Override
    public UserModel findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        UserModel user = restTemplate.getForObject(backendServerUrl + "/api/user/login/" + login, UserModel.class);
        return user;
    }

    @Override
    public List<UserModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserModel[] userResponse = restTemplate.getForObject(backendServerUrl + "/api/user", UserModel[].class);
        return userResponse == null ? Collections.emptyList() : Arrays.asList(userResponse);
    }

    @Override
    public void deleteUser(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "api/user/" + id);
    }


}
