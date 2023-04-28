package com.acapa.ecoturismo.dtos;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PruebaDTO {
    long id;
    @NotEmpty
    @Size(min = 3, message = "El nombre de la iniciativa debe de tener almenos 3 letras")
    String initiativeName;
    @NotEmpty
    @Size(min = 3, message = "la descripción de la iniciativa debe de tener almenos 3 letras")
    String initiativeDescription;
    @NotEmpty
    @Size(min = 3, message = "La mision  de la iniciativa debe de tener almenos 3 letras")
    String initiativeMision;
    @NotEmpty
    @Size(min = 3, message = "por lo menos debe de colocar un objetivo de la iniciativa y  debe de tener almenos 3 letras")
    String initiativeObject;
    private VeredaDTOUse vereda;
    private ContactDTOUse contact;
    private Set<AttractivesDTOUse> attractives;

    public Set<AttractivesDTOUse> getAttractives() {
        return attractives;
    }

    public void setAttractives(Set<AttractivesDTOUse> attractives) {
        this.attractives = attractives;
    }

    public VeredaDTOUse getVereda() {
        return vereda;
    }

    public void setVereda(VeredaDTOUse vereda) {
        this.vereda = vereda;
    }

    public ContactDTOUse getContact() {
        return contact;
    }

    public void setContact(ContactDTOUse contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public PruebaDTO() {
        super();
    }
}
