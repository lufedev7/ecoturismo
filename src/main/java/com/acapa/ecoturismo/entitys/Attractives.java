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
@Table(name = "attractive", uniqueConstraints = { @UniqueConstraint(columnNames = { "nameattractive" }) })
public class Attractives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameattractive", nullable = false, length = 100)
    private String nameAttractive;

    @Column(name = "descriptionattractive", nullable = false, length = 4000)
    private String descriptionAttractive;
    @Column(name = "featured", nullable = false, length = 200)
    private boolean featured;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiative_id", nullable = false)
    private prueba prueba;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeattractive_id", nullable = false)
    private TypesAttractives typesAttractives;

    @JsonBackReference
    @OneToMany(mappedBy = "attractive", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResourcesAttractives> resourceAttractives = new HashSet<>();

    public TypesAttractives getTypesAttractives() {
        return typesAttractives;
    }

    public void setTypesAttractives(TypesAttractives typesAttractives) {
        this.typesAttractives = typesAttractives;
    }

    public prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(prueba prueba) {
        this.prueba = prueba;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionAttractive() {
        return descriptionAttractive;
    }

    public void setDescriptionAttractive(String descriptionAttractive) {
        this.descriptionAttractive = descriptionAttractive;
    }

    public Long getId() {
        return id;
    }

    public String getNameAttractive() {
        return nameAttractive;
    }

    public void setNameAttractive(String nameAttractive) {
        this.nameAttractive = nameAttractive;
    }

    public Attractives() {
        super();
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public Set<ResourcesAttractives> getResourceAttractives() {
        return resourceAttractives;
    }

    public void setResourceAttractives(Set<ResourcesAttractives> resourceAttractives) {
        this.resourceAttractives = resourceAttractives;
    }

}
