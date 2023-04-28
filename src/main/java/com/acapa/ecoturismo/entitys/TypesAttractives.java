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
@Table(name = "typesattractives", uniqueConstraints = { @UniqueConstraint(columnNames = { "typeattractives" }) })
public class TypesAttractives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "typeattractives", nullable = false, length = 100)
    private String typeAttractives;
    @Column(name = "descriptiontype", nullable = false, length = 100)
    private String descriptionType;
    @JsonBackReference
    @OneToMany(mappedBy = "typesAttractives", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Attractives> attractives = new HashSet<>();

    public Set<Attractives> getAttractives() {
        return attractives;
    }

    public void setAttractives(Set<Attractives> attractives) {
        this.attractives = attractives;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeAttractives() {
        return typeAttractives;
    }

    public void setTypeAttractives(String typeAttractives) {
        this.typeAttractives = typeAttractives;
    }

    public String getDescriptionType() {
        return descriptionType;
    }

    public void setDescriptionType(String descriptionType) {
        this.descriptionType = descriptionType;
    }

    public TypesAttractives() {
        super();
    }

}
