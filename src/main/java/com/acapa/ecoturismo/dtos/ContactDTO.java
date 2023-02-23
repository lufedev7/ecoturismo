package com.acapa.ecoturismo.dtos;

import java.util.HashSet;
import java.util.Set;

import com.acapa.ecoturismo.entitys.Initiative;
import com.acapa.ecoturismo.entitys.Vereda;

public class ContactDTO {
    long id;
    String contactName;
    String addresContact;
    String phoneNumber;
    String phoneNumber2;
    String email;

    private Set<Vereda> vereda = new HashSet<>();
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
    public ContactDTO() {
        super();
    }


}
