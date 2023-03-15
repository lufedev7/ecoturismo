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

import com.acapa.ecoturismo.dtos.TypeServicesDTO;
import com.acapa.ecoturismo.services.TypeServicesServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/typesservices")
public class TypeServicesControllers {
    @Autowired
    private TypeServicesServices typeServicesServices;

    @PostMapping
    public ResponseEntity<TypeServicesDTO> saveTypeServices(@RequestBody TypeServicesDTO typeServicesDTO) {
        return new ResponseEntity<>(typeServicesServices.createTypeService(typeServicesDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public List<TypeServicesDTO> getAlltypesServices(){
        return typeServicesServices.getAllTypeService();
    }
    @GetMapping("/{idTypeService}")
    public ResponseEntity<TypeServicesDTO> getTypeServiceById(@PathVariable(name ="idTypeService") long idTypeService){
        return ResponseEntity.ok(typeServicesServices.getTypeServiceById(idTypeService));
    }
    @PutMapping("/{idTypeService}")
    public ResponseEntity <TypeServicesDTO> updateTypeService(@Valid @RequestBody TypeServicesDTO typeServicesDTO, @PathVariable(name="idTypeService")long idTypeService){
        return new ResponseEntity<>(typeServicesServices.updateTypeService(idTypeService, typeServicesDTO),HttpStatus.OK);
    }
    @DeleteMapping("/{idTypeService}")
    public ResponseEntity<String>deleteTypeService(@PathVariable(name = "idTypeService")long idTypeService){
        typeServicesServices.deleteTypeService(idTypeService);
        return new ResponseEntity<>("Tipo de servicio eliminado correctamente",HttpStatus.OK);
    }

}
