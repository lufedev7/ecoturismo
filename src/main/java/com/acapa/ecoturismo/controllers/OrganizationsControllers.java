package com.acapa.ecoturismo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acapa.ecoturismo.dtos.OrganizationsDTO;
import com.acapa.ecoturismo.dtos.OrganizationsResponse;
import com.acapa.ecoturismo.services.OrganizationsServices;
import com.acapa.ecoturismo.utils.appConst;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationsControllers {
    @Autowired
    private OrganizationsServices organizationsServices;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
     public  OrganizationsResponse listOrganization(
        @RequestParam(value = "nomPage",defaultValue = appConst.Mesure_Page_For_Default,required = false) int numberPage,
        @RequestParam(value = "pageSize",defaultValue = appConst.Number_Page_For_Default,required = false) int measure,
        @RequestParam(value = "sortBy",defaultValue = appConst.Order_By_For_Default,required = false) String orderBy,
        @RequestParam(value = "sortDir",defaultValue = appConst.Order_By_For_Dir,required = false)String sortDir){
        return organizationsServices.getOrganization(numberPage, measure, orderBy, sortDir);
     }
    @PostMapping
    public ResponseEntity<OrganizationsDTO> saveOrganizations(@Valid @RequestBody OrganizationsDTO organizationsDTO){
        return new ResponseEntity<>(organizationsServices.createOrganization(organizationsDTO),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationsDTO> getOrganizationsById(@PathVariable(name ="id") long id){
        return ResponseEntity.ok(organizationsServices.getOrganizationsById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity <OrganizationsDTO> updateOrganizationsForId(@Valid @RequestBody OrganizationsDTO organizationsDTO,
    @PathVariable(name = "id")long id ){
        OrganizationsDTO organizacionResponse = organizationsServices.updateOrganizacion(organizationsDTO, id);
        return new ResponseEntity<>(organizacionResponse,HttpStatus.OK) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrganization(@PathVariable(name = "id")long id){
     organizationsServices.deleteOrganization(id);
     return new ResponseEntity<>("Orgaizations delete succesfully",HttpStatus.OK);
    }
}
