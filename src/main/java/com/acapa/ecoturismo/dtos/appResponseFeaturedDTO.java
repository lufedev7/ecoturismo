package com.acapa.ecoturismo.dtos;

import java.util.List;

public class appResponseFeaturedDTO {
    List<ServicesFeaturedDTO> services;
    List<AppsAttractives> attractives;

    public List<AppsAttractives> getAttractives() {
        return attractives;
    }

    public void setAttractives(List<AppsAttractives> attractives) {
        this.attractives = attractives;
    }

    public List<ServicesFeaturedDTO> getServices() {
        return services;
    }

    public void setServices(List<ServicesFeaturedDTO> services) {
        this.services = services;
    }

    public appResponseFeaturedDTO() {
        super();
    }

}
