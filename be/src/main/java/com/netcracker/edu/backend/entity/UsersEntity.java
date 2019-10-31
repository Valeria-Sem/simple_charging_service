package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "charging_service", catalog = "")
public class UsersEntity {
    private int idUsers;
    private String login;
    private String password;
    private Object role;
//    private Collection<CustomerEntity> customersByIdUsers;
//    private Collection<OrganisationEntity> organisationsByIdUsers;

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
    @Column(name = "role")
    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
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

//    @Override
//    public int hashCode() {
//        return Objects.hash(idUsers, login, password, role);
//    }
//
//    @OneToMany(mappedBy = "usersByIdUsers")
//    public Collection<CustomerEntity> getCustomersByIdUsers() {
//        return customersByIdUsers;
//    }
//
//    public void setCustomersByIdUsers(Collection<CustomerEntity> customersByIdUsers) {
//        this.customersByIdUsers = customersByIdUsers;
//    }
//
//    @OneToMany(mappedBy = "usersByIdUsers")
//    public Collection<OrganisationEntity> getOrganisationsByIdUsers() {
//        return organisationsByIdUsers;
//    }
//
//    public void setOrganisationsByIdUsers(Collection<OrganisationEntity> organisationsByIdUsers) {
//        this.organisationsByIdUsers = organisationsByIdUsers;
//    }
}
