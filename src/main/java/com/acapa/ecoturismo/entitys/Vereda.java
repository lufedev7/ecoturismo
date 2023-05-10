package com.acapa.ecoturismo.entitys;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "vereda", uniqueConstraints = { @UniqueConstraint(columnNames = { "veredaname" }),
        @UniqueConstraint(columnNames = { "coorvereda" }) })
public class Vereda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "veredaname", nullable = false, length = 200)
    private String veredaName;
    @Column(name = "habinumvereda", nullable = false, length = 100)
    private long HabiNumVereda;
    @Column(name = "coorvereda", nullable = false, length = 200)
    private String CoorVereda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organizations organizations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @JsonBackReference
    @OneToMany(mappedBy = "vereda", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<prueba> prueba = new HashSet<>();

    public Set<prueba> getPrueba() {
        return prueba;
    }

    public void setPrueba(Set<prueba> prueba) {
        this.prueba = prueba;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVeredaName() {
        return veredaName;
    }

    public void setVeredaName(String veredaName) {
        this.veredaName = veredaName;
    }

    public long getHabiNumVereda() {
        return HabiNumVereda;
    }

    public void setHabiNumVereda(long habiNumVereda) {
        HabiNumVereda = habiNumVereda;
    }

    public String getCoorVereda() {
        return CoorVereda;
    }

    public void setCoorVereda(String coorVereda) {
        CoorVereda = coorVereda;
    }

    public Organizations getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Vereda() {
        super();
    }

}
