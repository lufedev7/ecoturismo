package com.acapa.ecoturismo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ServicesDTO {
    
    private long id;
    @NotEmpty
    @Size(min = 3, message = "El nombre del servicio debe de tener almenos 3 letras")
    private String servicesName;
    @NotEmpty
    private String pricePerson;
    @NotEmpty
    @Size(min = 3, message = "la descripción del servicio debe de tener almenos 3 letras")
    private String description;
    private boolean featured;
    private TypeServicesDTO typeServises;
      private InitiativeDTO initiative;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getServicesName() {
        return servicesName;
    }
    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }
    public String getPricePerson() {
        return pricePerson;
    }
    public void setPricePerson(String pricePerson) {
        this.pricePerson = pricePerson;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ServicesDTO() {
    super();
    }
    public boolean isFeatured() {
        return featured;
    }
    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
     public TypeServicesDTO getTypeServises() {
        return typeServises;
    }
    public void setTypeServises(TypeServicesDTO typeServises) {
        this.typeServises = typeServises;
    }
     public InitiativeDTO getInitiative() {
        return initiative;
    }
    public void setInitiative(InitiativeDTO initiative) {
        this.initiative = initiative;
    } 

}
