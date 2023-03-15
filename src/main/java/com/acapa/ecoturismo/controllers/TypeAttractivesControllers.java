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

import com.acapa.ecoturismo.dtos.TypesAttractivesDTO;
import com.acapa.ecoturismo.services.TypeAttractivesServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/typeattractives")
public class TypeAttractivesControllers {
    @Autowired
    private TypeAttractivesServices typeAttractivesServices;

    @PostMapping
    public ResponseEntity<TypesAttractivesDTO> saveTypeServices(@RequestBody TypesAttractivesDTO typesAttractivesDTO) {
        return new ResponseEntity<>(typeAttractivesServices.createTypeAttractives(typesAttractivesDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public List<TypesAttractivesDTO> getAlltypesAttractives(){
        return typeAttractivesServices.getAllTypeAttractive();
    }
    @GetMapping("/{idTypeAttractive}")
    public ResponseEntity<TypesAttractivesDTO> getTypeAttractiveById(@PathVariable(name ="idTypeAttractive") long idTypeAttractive){
        return ResponseEntity.ok(typeAttractivesServices.getTypeAttractiveById(idTypeAttractive));
    }
    @PutMapping("/{idTypeAttractive}")
    public ResponseEntity <TypesAttractivesDTO> updateTypeAttractive(@Valid @RequestBody TypesAttractivesDTO typesAttractivesDTO, @PathVariable(name="idTypeAttractive")long idTypeAttractive){
        return new ResponseEntity<>(typeAttractivesServices.updateTypeAttractive(idTypeAttractive, typesAttractivesDTO),HttpStatus.OK);
    }
    @DeleteMapping("/{idTypeAttractive}")
    public ResponseEntity<String>deleteTypeAttractive(@PathVariable(name = "idTypeAttractive")long idTypeAttractive){
        typeAttractivesServices.deleteTypeAttractive(idTypeAttractive);
        return new ResponseEntity<>("Tipo de Attractivo eliminado correctamente",HttpStatus.OK);
    }
}
