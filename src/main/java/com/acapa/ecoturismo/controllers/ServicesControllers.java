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

import com.acapa.ecoturismo.dtos.ServicesDTO;
import com.acapa.ecoturismo.dtos.TypeServicesDTO;
import com.acapa.ecoturismo.services.ServicesServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class ServicesControllers {
    @Autowired
    private ServicesServices servicesServices;

    @PostMapping("/initiatives/{initiativeId}/services/{typeServiceId}")
    public ResponseEntity<ServicesDTO> saveService( @PathVariable(value = "initiativeId")Long initiativeId,
    @PathVariable(value = "typeServiceId")Long typeServiceId,
    @Valid @RequestBody ServicesDTO servicesDTO){
        return new ResponseEntity<>(servicesServices.createServices(initiativeId, typeServiceId, servicesDTO),HttpStatus.CREATED);
    }
    @PostMapping("/initiative/{initiativeId}/service/{typeServiceId}")
    public ResponseEntity<TypeServicesDTO> prueba( @PathVariable(value = "initiativeId")Long initiativeId,
    @PathVariable(value = "typeServiceId")Long typeServiceId,
    @Valid @RequestBody ServicesDTO servicesDTO){
        return new ResponseEntity<>(servicesServices.prueba(initiativeId, typeServiceId, servicesDTO),HttpStatus.CREATED);
    }


    @GetMapping("/initiatives/{initiativeId}/services")
    public List<ServicesDTO> listServicesByInitiative(@PathVariable(value = "initiativeId") Long initiativeId){
        return servicesServices.getserviceForInitiativeId(initiativeId);
    }
    @GetMapping("/initiatives/{initiativeId}/services/{serviceId}")
    public ResponseEntity<ServicesDTO> getServiceById(@PathVariable(value = "initiativeId") Long initiativeId,
    @PathVariable(value = "serviceId") Long serviceId){
      ServicesDTO servicesDTO = servicesServices.getServiceById(initiativeId, serviceId);
       return new ResponseEntity<>(servicesDTO,HttpStatus.OK);
    }

    @PutMapping("/initiatives/{initiativeId}/services/{serviceId}")
     public ResponseEntity<ServicesDTO> updateServicesBy( @PathVariable(value = "initiativeId") Long initiativeId,
     @PathVariable(value = "serviceId") Long serviceId,@Valid @RequestBody ServicesDTO servicesDTO){
        ServicesDTO serviceUpdate = servicesServices.updateService(initiativeId, serviceId, servicesDTO);
        return new ResponseEntity<>(serviceUpdate,HttpStatus.OK);

     }

     @DeleteMapping("/initiatives/{initiativeId}/services/{serviceId}")
     public ResponseEntity<String> deleteservice(@PathVariable(value = "initiativeId") Long initiativeId,
     @PathVariable(value = "serviceId") Long serviceId){
           servicesServices.deleteService(initiativeId, serviceId);
        return new ResponseEntity<>("attractive  Delete succesfully",HttpStatus.OK);
     }
}
