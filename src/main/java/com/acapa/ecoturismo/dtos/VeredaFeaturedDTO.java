package com.acapa.ecoturismo.dtos;

public class VeredaFeaturedDTO {
    private String veredaName;
    private OrganizationsFeaturedDTO organizations;

    public String getVeredaName() {
        return veredaName;
    }

    public void setVeredaName(String veredaName) {
        this.veredaName = veredaName;
    }

    public OrganizationsFeaturedDTO getOrganizations() {
        return organizations;
    }

    public void setOrganizations(OrganizationsFeaturedDTO organizations) {
        this.organizations = organizations;
    }

    public VeredaFeaturedDTO() {
        super();
    }

}
