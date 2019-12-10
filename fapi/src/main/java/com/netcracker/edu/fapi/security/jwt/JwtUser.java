//package com.netcracker.edu.fapi.security.jwt;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.netcracker.edu.fapi.models.enums.Role;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class JwtUser implements UserDetails {
//
//    private final int idUser;
//    private final String login;
//    private final String password;
//  //  private Role role;
//    private final boolean enabled;
//    private final Collection<? extends GrantedAuthority> authorities;
//
//    public JwtUser(int idUser, String login, String password
//    ,Collection<? extends GrantedAuthority> authorities, boolean enabled) {
//        this.idUser = idUser;
//        this.login = login;
//        this.password = password;
//     //   this.role = role;
//        this.enabled = enabled;
//        this.authorities = authorities;
//    }
//
//    @JsonIgnore
//    public int getIdUser(){
//        return idUser;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @JsonIgnore
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return login;
//    }
//
////    @JsonIgnore
////    public Role getRole(){
////        return role;
////    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//}
