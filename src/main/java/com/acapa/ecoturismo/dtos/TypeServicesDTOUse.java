package com.acapa.ecoturismo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TypeServicesDTOUse {
    private long id;
    @NotEmpty
    @Size(min = 3, message = "El tipo de servicio debe de tener almenos 3 letras")
    private String servicesType;
    @NotEmpty
    private String descriptionTypeServices;

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

    public TypeServicesDTOUse() {
        super();
    }

}
