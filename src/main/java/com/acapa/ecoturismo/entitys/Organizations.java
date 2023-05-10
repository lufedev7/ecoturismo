package com.acapa.ecoturismo.entitys;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "organizations", uniqueConstraints = {
        @UniqueConstraint(name = "organizationName_title", columnNames = { "organizationName" })
})
public class Organizations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "organizationName", nullable = false, length = 100)
    private String organizationName;
    @Column(name = "organizationWebSite", nullable = false)
    private String organizationWebSite;
    @Column(name = "organizationFacebook", nullable = false)
    private String organizationFacebook;
    @Column(name = "organizationInstagram", nullable = false)
    private String organizationInstagram;
    @Column(name = "organizationYoutube", nullable = false)
    private String organizationYoutube;
    @Column(name = "organizationMision", nullable = false, length = 4000)
    private String organizationMision;
    @Column(name = "organizationVision", nullable = false, length = 4000)
    private String organizationVision;
    @Column(name = "organizationLocation", nullable = false)
    private String organizationLocation;
    @Column(name = "organizationAddress", nullable = false)
    private String organizationAddress;
    @Column(name = "organizationPhone", nullable = false)
    private String organizationPhone;
    @Column(name = "organizationLogo", nullable = false)
    private String organizationLogo;

    @JsonBackReference
    @OneToMany(mappedBy = "organizations", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vereda> vereda = new HashSet<>();

    public Set<Vereda> getVereda() {
        return vereda;
    }

    public void setVereda(Set<Vereda> vereda) {
        this.vereda = vereda;
    }

    public Long getId() {
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

    public Organizations() {
        super();
    }

    public Organizations(long id, String organizationName, String organizationWebSite, String organizationFacebook,
            String organizationInstagram, String organizationYoutube, String organizationMision,
            String organizationVision, String organizationLocation, String organizationAddress,
            String organizationPhone, String organizationLogo) {
        this.id = id;
        this.organizationName = organizationName;
        this.organizationWebSite = organizationWebSite;
        this.organizationFacebook = organizationFacebook;
        this.organizationInstagram = organizationInstagram;
        this.organizationYoutube = organizationYoutube;
        this.organizationMision = organizationMision;
        this.organizationVision = organizationVision;
        this.organizationLocation = organizationLocation;
        this.organizationAddress = organizationAddress;
        this.organizationPhone = organizationPhone;
        this.organizationLogo = organizationLogo;
    }

}
