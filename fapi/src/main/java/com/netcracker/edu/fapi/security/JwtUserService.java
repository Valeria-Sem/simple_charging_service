//package com.netcracker.edu.fapi.security;
//
//import com.netcracker.edu.fapi.models.UserModel;
//import com.netcracker.edu.fapi.security.jwt.JwtUser;
//import com.netcracker.edu.fapi.security.jwt.JwtUserFactory;
//import com.netcracker.edu.fapi.service.UserService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JwtUserService implements UserDetailsService {
//
//    private final UserService userService;
//
//    public JwtUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        UserModel user = userService.findByLogin(login);
//
//        if(user == null){
//            throw new UsernameNotFoundException("User with login: " + login + "not found");
//        }
//
//        JwtUser jwtUser = JwtUserFactory.create(user);
//        return jwtUser;
//    }
//}
