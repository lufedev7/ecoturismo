package com.acapa.ecoturismo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ResourcesAttractivesDTOUse {
    private Long id;
    @NotEmpty
    @Size(min = 3, message = "El nombre del recurso debe de tener almenos 3 letras")
    private String nameResource;
    @NotEmpty
    @Size(min = 3, message = "El nombre de la vereda debe de tener almenos 3 letras")
    private String description;
    @NotEmpty
    @Size(min = 4, message = "ingrese el link")
    private String linkResource;
    private boolean typeResource;
    @Size(min = 3, message = "Ingrese la hora  debe de tener almenos 3 letras")
    private String timeStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameResource() {
        return nameResource;
    }

    public void setNameResource(String nameResource) {
        this.nameResource = nameResource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkResource() {
        return linkResource;
    }

    public void setLinkResource(String linkResource) {
        this.linkResource = linkResource;
    }

    public boolean isTypeResource() {
        return typeResource;
    }

    public void setTypeResource(boolean typeResource) {
        this.typeResource = typeResource;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ResourcesAttractivesDTOUse() {
        super();
    }

}
