package com.acapa.ecoturismo.dtos;


public class ContactDTO {
    long id;
    String contactName;
    String addresContact;
    String phoneNumber;
    String phoneNumber2;
    String email;

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
   
    public ContactDTO() {
        super();
    }


}
