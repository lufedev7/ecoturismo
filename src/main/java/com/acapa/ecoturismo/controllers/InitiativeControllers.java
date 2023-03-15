package com.acapa.ecoturismo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acapa.ecoturismo.dtos.InitiativeDTO;
import com.acapa.ecoturismo.services.InitiativeServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class InitiativeControllers {
    @Autowired
    private InitiativeServices initiativeServices;
    
    @PostMapping("/vereda/{veredaId}/initiative/{contactId}")
    public ResponseEntity<InitiativeDTO> saveInitiative( @PathVariable(value = "veredaId")Long veredaId,
    @PathVariable(value = "contactId")Long contactId,
    @Valid @RequestBody InitiativeDTO initiativeDTO){
        return new ResponseEntity<>(initiativeServices.createInitiavive(veredaId, contactId,initiativeDTO),HttpStatus.CREATED);
    }


    @GetMapping("/vereda/{veredaId}/initiative")
    public List<InitiativeDTO> listInitiativeByVereda(@PathVariable(value = "veredaId") Long veredaId){
        return initiativeServices.getInitiativeByVereda(veredaId);
    }
    @GetMapping("/vereda/{veredaId}/initiative/{initiativeId}")
    public ResponseEntity<InitiativeDTO> getInitiativeById(@PathVariable(value = "veredaId") Long veredaId,
    @PathVariable(value = "initiativeId") Long initiativeId){
      InitiativeDTO initiativeDTO = initiativeServices.getInitiativeById(veredaId, initiativeId); 
       return new ResponseEntity<>(initiativeDTO,HttpStatus.OK);
    }

    @PutMapping("/vereda/{veredaId}/initiative/{initiativeId}")
     public ResponseEntity<InitiativeDTO> updateInitiative( @PathVariable(value = "veredaId") Long veredaId,
     @PathVariable(value = "initiativeId") Long initiativeId,@Valid @RequestBody InitiativeDTO initiativeDTO){
        InitiativeDTO initiativeUpdate = initiativeServices.updateInitiative(veredaId, initiativeId, initiativeDTO);
        return new ResponseEntity<>(initiativeUpdate,HttpStatus.OK);

     }

     @DeleteMapping("/vereda/{veredaId}/initiative/{initiativeId}")
     public ResponseEntity<String> deleteInitiative(@PathVariable(value = "veredaId") Long veredaId,
     @PathVariable(value = "initiativeId") Long initiativeId){
        initiativeServices.deleteInitiative(veredaId, initiativeId);
        return new ResponseEntity<>("Initiative  Delete succesfully",HttpStatus.OK);
     }
}
