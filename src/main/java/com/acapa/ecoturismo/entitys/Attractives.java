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
@Table(name = "attractive", uniqueConstraints = { @UniqueConstraint(columnNames={"nameattractive"})})
public class Attractives {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameattractive", nullable = false, length = 100)
    private String nameAttractive;

    @Column(name = "descriptionattractive", nullable = false, length = 100)
    private String descriptionAttractive;
    @Column(name = "featured", nullable = false, length = 200)
    private boolean featured;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiative_id",nullable = false)
    private Initiative initiative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeattractive_id",nullable = false)
    private TypesAttractives typesAttractive;

    @JsonBackReference
    @OneToMany(mappedBy = "attractive",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ResourcesAttractives> resourceAttractives = new HashSet<>();


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
    public Initiative getInitiative() {
        return initiative;
    }
    public void setInitiative(Initiative initiative) {
        this.initiative = initiative;
    }
    public Attractives() {
    super();
    }
    public TypesAttractives getTypesAttractive() {
        return typesAttractive;
    }
    public void setTypesAttractive(TypesAttractives typesAttractive) {
        this.typesAttractive = typesAttractive;
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