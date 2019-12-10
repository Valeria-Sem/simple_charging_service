package com.netcracker.edu.fapi.security.jwt;

import com.netcracker.edu.fapi.models.enums.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import com.netcracker.edu.fapi.models.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory(){
    }

    public static JwtUser create(UserModel user){
        return new JwtUser(
                user.getIdUser(),
                user.getLogin(),
                user.getPassword(),
                user.getRole());
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<Role> userRoles){
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name())
                ).collect(Collectors.toList());

    }

}
