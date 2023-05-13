package com.acapa.ecoturismo.dtos;

public class appPruebaDTO {
    String initiativeName;
    private VeredaFeaturedDTO vereda;

    public VeredaFeaturedDTO getVereda() {
        return vereda;
    }

    public void setVereda(VeredaFeaturedDTO vereda) {
        this.vereda = vereda;
    }

    public String getInitiativeName() {
        return initiativeName;
    }

    public void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName;
    }

    public appPruebaDTO() {
        super();
    }

}
