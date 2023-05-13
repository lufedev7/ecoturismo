package com.acapa.ecoturismo.dtos;

public class OrganizationsFeaturedDTO {
    private String organizationName;
    private String organizationLogo;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationLogo() {
        return organizationLogo;
    }

    public void setOrganizationLogo(String organizationLogo) {
        this.organizationLogo = organizationLogo;
    }

    public OrganizationsFeaturedDTO() {
        super();
    }

}
