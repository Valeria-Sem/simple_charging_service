package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Users;
import com.netcracker.edu.fapi.service.UsersSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("customUsersDetailsService")
public class UsersServiceImpl implements UserDetailsService, UsersSevice {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Users findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        Users users = restTemplate.getForObject(backendServerUrl + "/api/user/login" + login, Users.class);
        return users;
    }

    @Override
    public List<Users> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Users[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/user", Users[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public Users save(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user",user, Users.class).getBody();
    }

    //возможно определение на дублирование логина
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users = findByLogin(login);
        if (users == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(users.getLogin(), users.getPassword(), getAuthority(users));
        //return null;
    }

    private Set<SimpleGrantedAuthority> getAuthority(Users users) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + users.getRole()));
        return authorities;
    }
}
