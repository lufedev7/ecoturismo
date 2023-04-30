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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;
import com.acapa.ecoturismo.dtos.ResourcesServicesUseDTO;
import com.acapa.ecoturismo.services.ResourcesServicesServices;
import com.acapa.ecoturismo.utils.appConst;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class ResourcesServicesControllers {
    @Autowired
    private ResourcesServicesServices resourcesServicesServices;

    @PostMapping("/services/{servicesId}/resourceservices")
    public ResponseEntity<ResourcesServicesUseDTO> saveResourcesServices(
            @PathVariable(value = "servicesId") Long servicesId,
            @Valid @RequestBody ResourcesServicesUseDTO resourcesServicesDTO) {
        return new ResponseEntity<>(resourcesServicesServices.createResourceService(servicesId, resourcesServicesDTO),
                HttpStatus.CREATED);
    }

    // Este metodo funciona correctamente
    @GetMapping("/services/{servicesId}/resourceservices")
    public List<ResourcesServicesDTO> listResourcesServicesByservices(
            @PathVariable(value = "servicesId") Long servicesId) {
        return resourcesServicesServices.getResourcesServiceForServiceId(servicesId);
    }

    // method funtinality succesfully
    @GetMapping("/services/{servicesId}/resourceservices/{resourcesServicesId}")
    public ResponseEntity<ResourcesServicesDTO> getResourcesServicesById(
            @PathVariable(value = "servicesId") Long servicesId,
            @PathVariable(value = "resourcesServicesId") Long resourcesServicesId) {
        ResourcesServicesDTO resourcesServicesDTO = resourcesServicesServices.getResourceServiceId(servicesId,
                resourcesServicesId);
        return new ResponseEntity<>(resourcesServicesDTO, HttpStatus.OK);
    }

    @PutMapping("/services/{servicesId}/resourceservices/{resourcesServicesId}")
    public ResponseEntity<ResourcesServicesUseDTO> updateResourceService(
            @PathVariable(value = "servicesId") Long servicesId,
            @PathVariable(value = "resourcesServicesId") Long resourcesServicesId,
            @Valid @RequestBody ResourcesServicesUseDTO resourcesServicesDTO) {
        ResourcesServicesUseDTO resourcesServicesUpdate = resourcesServicesServices
                .updateResourceService(servicesId, resourcesServicesId, resourcesServicesDTO);
        return new ResponseEntity<>(resourcesServicesUpdate, HttpStatus.OK);

    }

    // method working correctly
    @DeleteMapping("/services/{servicesId}/resourceservices/{resourcesServicesId}")
    public ResponseEntity<String> deleteResourcesServices(@PathVariable(value = "servicesId") Long servicesId,
            @PathVariable(value = "resourcesServicesId") Long resourcesServicesId) {
        resourcesServicesServices.deleteResourceService(servicesId, resourcesServicesId);
        return new ResponseEntity<>("Resource service  Delete succesfully", HttpStatus.OK);
    }

    @GetMapping("/services/resourceservices/all")
    public List<ResourcesServicesDTO> listAllResourcesServicesByservices(
            @RequestParam(value = "nomPage", defaultValue = appConst.Mesure_Page_For_Default, required = false) int numberPage,
            @RequestParam(value = "pageSize", defaultValue = appConst.Number_Page_For_Default, required = false) int measure,
            @RequestParam(value = "sortBy", defaultValue = appConst.Order_By_For_Default, required = false) String orderBy,
            @RequestParam(value = "sortDir", defaultValue = appConst.Order_By_For_Dir, required = false) String sortDir) {

        return resourcesServicesServices.getAllResourceServices(numberPage, measure, orderBy, sortDir);
    }
}
