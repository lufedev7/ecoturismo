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

import com.acapa.ecoturismo.dtos.AttractivesDTO;
import com.acapa.ecoturismo.services.AttractivesServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class AttractivesControllers {
 @Autowired
 private AttractivesServices attractivesServices;
 
 @PostMapping("/initiatives/{initiativeId}/attractives/{attractiveId}")
    public ResponseEntity<AttractivesDTO> saveAttractive( @PathVariable(value = "initiativeId")Long initiativeId,
    @PathVariable(value = "attractiveId")Long attractiveId,
    @Valid @RequestBody AttractivesDTO attractivesDTO){
        return new ResponseEntity<>(attractivesServices.createAttractive(initiativeId, attractiveId, attractivesDTO) ,HttpStatus.CREATED);
    }


    @GetMapping("/initiatives/{initiativeId}/attractive")
    public List<AttractivesDTO> listAttractiveByInitiative(@PathVariable(value = "initiativeId") Long initiativeId){
        return attractivesServices.getAttractiveForInitiativeId(initiativeId);
    }
    @GetMapping("/initiatives/{initiativeId}/attractives/{attractiveId}")
    public ResponseEntity<AttractivesDTO> getAttractiveById(@PathVariable(value = "initiativeId") Long initiativeId,
    @PathVariable(value = "attractiveId") Long attractiveId){
      AttractivesDTO attractivesDTO = attractivesServices.getAttractiveById(initiativeId, attractiveId);
       return new ResponseEntity<>(attractivesDTO,HttpStatus.OK);
    }

    @PutMapping("/initiatives/{initiativeId}/attractives/{attractiveId}")
     public ResponseEntity<AttractivesDTO> updateAttractivesBy( @PathVariable(value = "initiativeId") Long initiativeId,
     @PathVariable(value = "attractiveId") Long attractiveId,@Valid @RequestBody AttractivesDTO attractivesDTO){
        AttractivesDTO attractivesUpdate = attractivesServices.updateAttractive(initiativeId, attractiveId, attractivesDTO);
        return new ResponseEntity<>(attractivesUpdate,HttpStatus.OK);

     }

     @DeleteMapping("/initiatives/{initiativeId}/attractives/{attractiveId}")
     public ResponseEntity<String> deleteAttractives(@PathVariable(value = "initiativeId") Long initiativeId,
     @PathVariable(value = "attractiveId") Long attractiveId){
           attractivesServices.deleteAttractive(initiativeId, attractiveId);
        return new ResponseEntity<>("attractive  Delete succesfully",HttpStatus.OK);
     }
}