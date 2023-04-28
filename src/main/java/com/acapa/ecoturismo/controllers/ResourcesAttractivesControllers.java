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

import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTO;
import com.acapa.ecoturismo.services.ResourcesAttractivesServices;
import com.acapa.ecoturismo.utils.appConst;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class ResourcesAttractivesControllers {
@Autowired
ResourcesAttractivesServices resourcesAttractivesServices;
@PostMapping("/attractives/{attractivesId}/resourcesattractive")
public ResponseEntity<ResourcesAttractivesDTO> saveResourcesAttractives( @PathVariable(value = "attractivesId")Long attractivesId,
@Valid @RequestBody ResourcesAttractivesDTO resourcesAttractivesDTO){
    return new ResponseEntity<>(resourcesAttractivesServices.createResourceAttractives(attractivesId, resourcesAttractivesDTO),HttpStatus.CREATED);
}


@GetMapping("/attractives/{attractivesId}/resourcesattractive")
public List<ResourcesAttractivesDTO> listResourcesAttractivesByAttractives(@PathVariable(value = "attractivesId") Long attractivesId){
    return resourcesAttractivesServices.getResourcesAttractivesForAttractivesId(attractivesId);
}
@GetMapping("/attractives/{attractivesId}/resourcesattractive/{resourcesattractivesId}")
public ResponseEntity<ResourcesAttractivesDTO> getResourcesAttractivesById(@PathVariable(value = "attractivesId") Long attractivesId,
@PathVariable(value = "resourcesattractivesId") Long resourcesattractivesId){
  ResourcesAttractivesDTO resourcesAttractivesDTO = resourcesAttractivesServices.getResourceAttractivesId(attractivesId, resourcesattractivesId);
   return new ResponseEntity<>(resourcesAttractivesDTO,HttpStatus.OK);
}

@PutMapping("/attractives/{attractivesId}/resourcesattractive/{resourcesattractivesId}")
 public ResponseEntity<ResourcesAttractivesDTO> updateResourceAttractive( @PathVariable(value = "attractivesId") Long attractivesId,
 @PathVariable(value = "resourcesattractivesId") Long resourcesattractivesId,@Valid @RequestBody ResourcesAttractivesDTO resourcesAttractivesDTO){
    ResourcesAttractivesDTO resourcesServicesUpdate = resourcesAttractivesServices.updateResourceAttractives(attractivesId, resourcesattractivesId, resourcesAttractivesDTO);
    return new ResponseEntity<>(resourcesServicesUpdate,HttpStatus.OK);

 }

 @DeleteMapping("/attractives/{attractivesId}/resourcesattractive/{resourcesattractivesId}")
 public ResponseEntity<String> deleteResourcesAttractives(@PathVariable(value = "attractivesId") Long attractivesId,
 @PathVariable(value = "resourcesattractivesId") Long resourcesattractivesId){
    resourcesAttractivesServices.deleteResourceAttractives(attractivesId, resourcesattractivesId);
    return new ResponseEntity<>("Resource service  Delete succesfully",HttpStatus.OK);
 }

 @GetMapping("/attractives/resourcesattractives/all")
 public List<ResourcesAttractivesDTO> listAllResourcesAttractives(
         @RequestParam(value = "nomPage", defaultValue = appConst.Mesure_Page_For_Default, required = false) int numberPage,
         @RequestParam(value = "pageSize", defaultValue = appConst.Number_Page_For_Default, required = false) int measure,
         @RequestParam(value = "sortBy", defaultValue = appConst.Order_By_For_Default, required = false) String orderBy,
         @RequestParam(value = "sortDir", defaultValue = appConst.Order_By_For_Dir, required = false) String sortDir) {

     return resourcesAttractivesServices.getAllResourceAttractives(numberPage, measure, orderBy, sortDir);
 }

}
