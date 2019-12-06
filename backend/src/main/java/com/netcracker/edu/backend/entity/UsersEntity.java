package com.netcracker.edu.backend.entity;

import com.netcracker.edu.backend.entity.enums.UsersRole;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "charging_service", catalog = "")
public class UsersEntity {
    private int idUsers;
    private String login;
    private String password;
    private UsersRole role;

    @Id
    @Column(name = "id_users")
    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public UsersRole getRole() {
        return role;
    }

    public void setRole(UsersRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return idUsers == that.idUsers &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsers, login, password, role);
    }

//    public enum UsersRole {
//        CUSTOMER,
//        ORGANISATION,
//        ADMIN
//    }

}
