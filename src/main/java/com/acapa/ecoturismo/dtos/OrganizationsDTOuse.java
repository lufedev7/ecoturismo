package com.acapa.ecoturismo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class OrganizationsDTOuse {
    private long id;
    @NotEmpty
    @Size(min = 2, message= "Organization name must have at least two characters")
    private String organizationName;
    @NotEmpty
    @Size(min = 5, message= "Organization web site must have at least five characters")
    private String organizationWebSite;
    @NotEmpty
    @Size(min = 2, message= "Organization Facebook must have at least two characters")
    private String organizationFacebook;
    @NotEmpty
    @Size(min = 2, message= "Organization Instagram must have at least two characters")
    private String organizationInstagram;
    @NotEmpty
    @Size(min = 2, message= "Organization Youtube must have at least two characters")
    private String organizationYoutube;
    @NotEmpty
    @Size(min = 10, message= "Organization mision must have at least ten characters")
    private String organizationMision;
    @NotEmpty
    @Size(min = 10, message= "Organization vision must have at least ten characters")
    private String organizationVision;
    @NotEmpty
    private String organizationLocation;
    @NotEmpty
    @Size(min = 2, message= "Organization name must have at least two characters")
    private String organizationAddress;
    @NotEmpty
    @Size(min = 7, message= "Organization name must have at least seven characters")
    private String organizationPhone;
    @NotEmpty
    private String organizationLogo;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getOrganizationName() {
        return organizationName;
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public String getOrganizationWebSite() {
        return organizationWebSite;
    }
    public void setOrganizationWebSite(String organizationWebSite) {
        this.organizationWebSite = organizationWebSite;
    }
    public String getOrganizationFacebook() {
        return organizationFacebook;
    }
    public void setOrganizationFacebook(String organizationFacebook) {
        this.organizationFacebook = organizationFacebook;
    }
    public String getOrganizationInstagram() {
        return organizationInstagram;
    }
    public void setOrganizationInstagram(String organizationInstagram) {
        this.organizationInstagram = organizationInstagram;
    }
    public String getOrganizationYoutube() {
        return organizationYoutube;
    }
    public void setOrganizationYoutube(String organizationYoutube) {
        this.organizationYoutube = organizationYoutube;
    }
    public String getOrganizationMision() {
        return organizationMision;
    }
    public void setOrganizationMision(String organizationMision) {
        this.organizationMision = organizationMision;
    }
    public String getOrganizationVision() {
        return organizationVision;
    }
    public void setOrganizationVision(String organizationVision) {
        this.organizationVision = organizationVision;
    }
    public String getOrganizationLocation() {
        return organizationLocation;
    }
    public void setOrganizationLocation(String organizationLocation) {
        this.organizationLocation = organizationLocation;
    }
    public String getOrganizationAddress() {
        return organizationAddress;
    }
    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }
    public String getOrganizationPhone() {
        return organizationPhone;
    }
    public void setOrganizationPhone(String organizationPhone) {
        this.organizationPhone = organizationPhone;
    }
    public String getOrganizationLogo() {
        return organizationLogo;
    }
    public void setOrganizationLogo(String organizationLogo) {
        this.organizationLogo = organizationLogo;
    }
    public OrganizationsDTOuse() {
    super();
    }


   


}
