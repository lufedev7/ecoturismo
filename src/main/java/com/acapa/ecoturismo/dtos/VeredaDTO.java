package com.acapa.ecoturismo.dtos;

import java.util.HashSet;
import java.util.Set;

import com.acapa.ecoturismo.entitys.Contact;
import com.acapa.ecoturismo.entitys.Initiative;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class VeredaDTO {

    private long id;
    @NotEmpty
    @Size(min = 3, message = "El nombre de la vereda debe de tener almenos 3 letras")
    private String veredaName;
    private long habiNumVereda;
    @NotEmpty
    private String coorVereda;
    // la lista de contactos esta presentando un error, el cual toca corregir.
    //private Contact contact;
    public long getId() {
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
        return habiNumVereda;
    }


    public void setHabiNumVereda(long habiNumVereda) {
        this.habiNumVereda = habiNumVereda;
    }


    public String getCoorVereda() {
        return coorVereda;
    }


    public void setCoorVereda(String coorVereda) {
        this.coorVereda = coorVereda;
    }
    /* 
    public Contact getContact() {
        return contact;
    }
    
    
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    */
   public VeredaDTO() {
        super();
    }





}
