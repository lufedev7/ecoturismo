package com.acapa.ecoturismo.entitys;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "services", uniqueConstraints = { @UniqueConstraint(columnNames = { "servicesname" }) })
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "servicesname", nullable = false, length = 200)
    private String servicesName;
    @Column(name = "priceperson", nullable = false, length = 100)
    private String pricePerson;
    @Column(name = "description", nullable = false, length = 3000)
    private String description;
    @Column(name = "featured", nullable = false, length = 200)
    private boolean featured;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiative_id", nullable = false)
    private prueba prueba;

    public prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(prueba prueba) {
        this.prueba = prueba;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResourcesServices> resourceServices = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeservice_id", nullable = false)
    private TypesServices typesServices;

    public TypesServices getTypesServices() {
        return typesServices;
    }

    public void setTypesServices(TypesServices typesServices) {
        this.typesServices = typesServices;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public String getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(String pricePerson) {
        this.pricePerson = pricePerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Services() {
        super();
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public Set<ResourcesServices> getResourceServices() {
        return resourceServices;
    }

    public void setResourceServices(Set<ResourcesServices> resourceServices) {
        this.resourceServices = resourceServices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
