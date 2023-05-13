package com.acapa.ecoturismo.dtos;

public class ServicesFeaturedDTO {

    private long id;
    private String servicesName;
    private String description;
    private boolean featured;
    private appPruebaDTO prueba;

    public appPruebaDTO getPrueba() {
        return prueba;
    }

    public void setPrueba(appPruebaDTO prueba) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public ServicesFeaturedDTO() {
        super();
    }

}
