package com.acapa.ecoturismo.dtos;

import java.util.Set;

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
    private pruebaDTOUse prueba;
    private TypeServicesDTOUse typeServices;
    private Set<ResourcesServicesUseDTO> resourceServices;

    public Set<ResourcesServicesUseDTO> getResourceServices() {
        return resourceServices;
    }

    public void setResourceServices(Set<ResourcesServicesUseDTO> resourceServices) {
        this.resourceServices = resourceServices;
    }

    public TypeServicesDTOUse getTypeServices() {
        return typeServices;
    }

    public void setTypeServices(TypeServicesDTOUse typeServices) {
        this.typeServices = typeServices;
    }

    public pruebaDTOUse getPrueba() {
        return prueba;
    }

    public void setPrueba(pruebaDTOUse prueba) {
        this.prueba = prueba;
    }

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

}
