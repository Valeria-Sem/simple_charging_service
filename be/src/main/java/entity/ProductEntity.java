package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "charging_service", catalog = "")
public class ProductEntity {
    private int idProduct;
    private int idOrganisation;
    private String name;
    private String description;
    private int monthPrise;
    private int idCategory;
    private OrganisationEntity organisationByIdOrganisation;
    private CategoryEntity categoryByIdCategory;
    private Collection<SubscriptionEntity> subscriptionsByIdProduct;

    @Id
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "id_organisation")
    public int getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(int idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "month_prise")
    public int getMonthPrise() {
        return monthPrise;
    }

    public void setMonthPrise(int monthPrise) {
        this.monthPrise = monthPrise;
    }

    @Basic
    @Column(name = "id_category")
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return idProduct == that.idProduct &&
                idOrganisation == that.idOrganisation &&
                monthPrise == that.monthPrise &&
                idCategory == that.idCategory &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idOrganisation, name, description, monthPrise, idCategory);
    }

    @ManyToOne
    @JoinColumn(name = "id_organisation", referencedColumnName = "id_organisation", nullable = false)
    public OrganisationEntity getOrganisationByIdOrganisation() {
        return organisationByIdOrganisation;
    }

    public void setOrganisationByIdOrganisation(OrganisationEntity organisationByIdOrganisation) {
        this.organisationByIdOrganisation = organisationByIdOrganisation;
    }

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", nullable = false)
    public CategoryEntity getCategoryByIdCategory() {
        return categoryByIdCategory;
    }

    public void setCategoryByIdCategory(CategoryEntity categoryByIdCategory) {
        this.categoryByIdCategory = categoryByIdCategory;
    }

    @OneToMany(mappedBy = "productByIdProduct")
    public Collection<SubscriptionEntity> getSubscriptionsByIdProduct() {
        return subscriptionsByIdProduct;
    }

    public void setSubscriptionsByIdProduct(Collection<SubscriptionEntity> subscriptionsByIdProduct) {
        this.subscriptionsByIdProduct = subscriptionsByIdProduct;
    }
}
