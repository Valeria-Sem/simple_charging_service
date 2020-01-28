package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.fapi.models.enums.Role;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

    private int idUser;
    private String login;
    private String password;
    private Role role;

    public UserModel() {
    }

    public UserModel(int idUser, String login, String password, Role role) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
