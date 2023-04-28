package com.acapa.ecoturismo.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "prueba", uniqueConstraints = { @UniqueConstraint(columnNames = { "initiativeName" }) })
public class prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "initiativeName", nullable = false, length = 100)
    String initiativeName;
    @Column(name = "initiativeDescription", nullable = false, length = 100)
    String initiativeDescription;
    @Column(name = "initiativeMision", nullable = false, length = 100)
    String initiativeMision;
    @Column(name = "initiativeObject", nullable = false, length = 100)
    String initiativeObject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "vereda_id", nullable = false)
    private Vereda vereda;

    public Vereda getVereda() {
        return vereda;
    }

    public void setVereda(Vereda vereda) {
        this.vereda = vereda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitiativeName() {
        return initiativeName;
    }

    public void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName;
    }

    public String getInitiativeDescription() {
        return initiativeDescription;
    }

    public void setInitiativeDescription(String initiativeDescription) {
        this.initiativeDescription = initiativeDescription;
    }

    public String getInitiativeMision() {
        return initiativeMision;
    }

    public void setInitiativeMision(String initiativeMision) {
        this.initiativeMision = initiativeMision;
    }

    public String getInitiativeObject() {
        return initiativeObject;
    }

    public void setInitiativeObject(String initiativeObject) {
        this.initiativeObject = initiativeObject;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public prueba() {
        super();
    }

}
