package com.acapa.ecoturismo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.acapa.ecoturismo.dtos.VeredaDTO;
import com.acapa.ecoturismo.services.VeredaServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class VeredaControllers {
    @Autowired
    private VeredaServices veredaServices;
    //
    //
    //
    @PostMapping("/organizations/{organizationsId}/vereda/{contactId}")
    public ResponseEntity<VeredaDTO> saveVereda( @PathVariable(value = "organizationsId")Long publicationsId,
    @PathVariable(value = "contactId")Long contactId,
    @Valid @RequestBody VeredaDTO veredaDTO){
        return new ResponseEntity<>(veredaServices.createVereda(publicationsId, contactId,veredaDTO),HttpStatus.CREATED);
    }


    @GetMapping("/organizations/{organizationId}/vereda")
    public List<VeredaDTO> listVeredaByOrganization(@PathVariable(value = "organizationId") Long organizationId){
        return veredaServices.getVeredaForOrganizationsId(organizationId);
    }
    @GetMapping("/organizations/{organizationId}/vereda/{veredaId}")
    public ResponseEntity<VeredaDTO> getVeredaById(@PathVariable(value = "organizationId") Long organizationId,
    @PathVariable(value = "veredaId") Long veredaId){
      VeredaDTO veredaDTO = veredaServices.getVeredaById(organizationId, veredaId);
       return new ResponseEntity<>(veredaDTO,HttpStatus.OK);
    }

    @PutMapping("/organizations/{organizationId}/vereda/{veredaId}")
     public ResponseEntity<VeredaDTO> updateVeredaBy( @PathVariable(value = "organizationId") Long organizationId,
     @PathVariable(value = "veredaId") Long veredaId,@Valid @RequestBody VeredaDTO veredaDTO){
        VeredaDTO veredaUpdate = veredaServices.updateVereda(organizationId, veredaId, veredaDTO);
        return new ResponseEntity<>(veredaUpdate,HttpStatus.OK);

     }

     @DeleteMapping("/organizations/{organizationId}/vereda/{veredaId}")
     public ResponseEntity<String> deleteComments(@PathVariable(value = "organizationId") Long organizationId,
     @PathVariable(value = "veredaId") Long veredaId){
        veredaServices.deleteVereda(organizationId, veredaId);
        return new ResponseEntity<>("Vereda  Delete succesfully",HttpStatus.OK);
     }
}
