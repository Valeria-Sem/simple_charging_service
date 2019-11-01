package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "charging_service", catalog = "")
public class CategoryEntity {
    private int idCategory;
    private String name;
 //   private Collection<ProductEntity> productsByIdCategory;

    @Id
    @Column(name = "id_category")
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return idCategory == that.idCategory &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, name);
    }

//    @OneToMany(mappedBy = "categoryByIdCategory")
//    public Collection<ProductEntity> getProductsByIdCategory() {
//        return productsByIdCategory;
//    }

//    public void setProductsByIdCategory(Collection<ProductEntity> productsByIdCategory) {
//        this.productsByIdCategory = productsByIdCategory;
//    }
}
