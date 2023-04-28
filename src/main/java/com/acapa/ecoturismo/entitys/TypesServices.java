package com.acapa.ecoturismo.entitys;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "typesservices", uniqueConstraints = { @UniqueConstraint(columnNames = { "servicestype" }) })
public class TypesServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "servicestype", nullable = false, length = 100)
    private String servicesType;
    @Column(name = "descriptiontypeservices", nullable = false, length = 100)
    private String descriptionTypeServices;

    @JsonBackReference
    @OneToMany(mappedBy = "typesServices", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Services> services = new HashSet<>();

    public Set<Services> getServices() {
        return services;
    }

    public void setServices(Set<Services> services) {
        this.services = services;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServicesType() {
        return servicesType;
    }

    public void setServicesType(String servicesType) {
        this.servicesType = servicesType;
    }

    public String getDescriptionTypeServices() {
        return descriptionTypeServices;
    }

    public void setDescriptionTypeServices(String descriptionTypeServices) {
        this.descriptionTypeServices = descriptionTypeServices;
    }

    public TypesServices() {
        super();
    }

    public TypesServices(long id, String servicesType, String descriptionTypeServices) {
        this.id = id;
        this.servicesType = servicesType;
        this.descriptionTypeServices = descriptionTypeServices;
    }

}
