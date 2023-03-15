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
import jakarta.validation.constraints.Email;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "contact",uniqueConstraints ={ @UniqueConstraint(columnNames={"contactName"}),
@UniqueConstraint(columnNames={"phoneNumber"}),
@UniqueConstraint(columnNames={"phoneNumber2"}),
@UniqueConstraint(columnNames={"email"})})
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "contactName", nullable = false, length = 100)
    String contactName;
    @Column(name = "addresContact", nullable = false, length = 100)
    String addresContact;
    @Column(name = "phoneNumber", nullable = false, length = 100)
    String phoneNumber;
    @Column(name = "phoneNumber2", nullable = false, length = 100)
    String phoneNumber2;
    @Email
    @Column(name = "email", nullable = false, length = 100)
    String email;

    @JsonBackReference
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Vereda> vereda = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Initiative> initiative = new HashSet<>();

    public long getId() {
        return id;
    }
    

    public void setId(long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddresContact() {
        return addresContact;
    }

    public void setAddresContact(String addresContact) {
        this.addresContact = addresContact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Vereda> getVereda() {
        return vereda;
    }

    public void setVereda(Set<Vereda> vereda) {
        this.vereda = vereda;
    }

    public Set<Initiative> getInitiative() {
        return initiative;
    }


    public void setInitiative(Set<Initiative> initiative) {
        this.initiative = initiative;
    }
    public Contact() {
        super();
    }




}
