package com.acapa.ecoturismo.dtos;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TypeServicesDTO {

    private long id;
    @NotEmpty
    @Size(min = 3, message = "El tipo de servicio debe de tener almenos 3 letras")
    private String servicesType;
    @NotEmpty
    private String descriptionTypeServices;
    private Set<ServicesDTOUse> services;

    public Set<ServicesDTOUse> getServices() {
        return services;
    }

    public void setServices(Set<ServicesDTOUse> services) {
        this.services = services;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServicesType() {
        return servicesType;
    }

    public void setServicesType(String servicesType) {
        this.servicesType = servicesType;
    }

    public String getDescriptionTypeServices() {
        return descriptionTypeServices;
    }

    public void setDescriptionTypeServices(String descriptionTypeServices) {
        this.descriptionTypeServices = descriptionTypeServices;
    }

    public TypeServicesDTO() {
        super();
    }

}
