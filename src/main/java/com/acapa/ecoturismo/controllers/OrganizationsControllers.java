package com.acapa.ecoturismo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acapa.ecoturismo.dtos.OrganizationsDTO;
import com.acapa.ecoturismo.services.OrganizationsServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationsControllers {
    @Autowired
    private OrganizationsServices organizationsServices;
    @PreAuthorize("hasRole('ADMIN')")
   @PostMapping
    public ResponseEntity<OrganizationsDTO> saveOrganizations(@Valid @RequestBody OrganizationsDTO organizationsDTO){
        return new ResponseEntity<>(organizationsServices.createOrganization(organizationsDTO),HttpStatus.CREATED);
    }
}
