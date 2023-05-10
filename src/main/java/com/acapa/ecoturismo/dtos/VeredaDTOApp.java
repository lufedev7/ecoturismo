package com.acapa.ecoturismo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class VeredaDTOApp {
    private long id;
    @NotEmpty
    @Size(min = 3, message = "El nombre de la vereda debe de tener almenos 3 letras")
    private String veredaName;
    private long habiNumVereda;
    @NotEmpty
    private String coorVereda;
    private OrganizationsDTOuse organizations;
    private ContactDTOUse contact;

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

    public OrganizationsDTOuse getOrganizations() {
        return organizations;
    }

    public void setOrganizations(OrganizationsDTOuse organizations) {
        this.organizations = organizations;
    }

    public ContactDTOUse getContact() {
        return contact;
    }

    public void setContact(ContactDTOUse contact) {
        this.contact = contact;
    }

    public VeredaDTOApp() {
        super();
    }

}
