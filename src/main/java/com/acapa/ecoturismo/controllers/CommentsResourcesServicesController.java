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

import com.acapa.ecoturismo.dtos.CommentsResourceServicesDTO;
import com.acapa.ecoturismo.services.CommentsResourcesServicesServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class CommentsResourcesServicesController {
    @Autowired
    private CommentsResourcesServicesServices commentsResourcesServicesServices;

    @PostMapping("/services/post/resourceservices/{resourceServicesId}/comments")
    public ResponseEntity<CommentsResourceServicesDTO> saveCommentsResourcesServices(
            @PathVariable(value = "resourceServicesId") Long resourceServicesId,
            @Valid @RequestBody CommentsResourceServicesDTO commentsResourceServicesDTO) {
        return new ResponseEntity<>(
                commentsResourcesServicesServices.createCommentsResourceService(resourceServicesId,
                        commentsResourceServicesDTO),
                HttpStatus.CREATED);
    }

    @GetMapping("/services/resourceservices/{resourceServicesId}/comments")
    public List<CommentsResourceServicesDTO> listcommentsResourcesServicesByresourceservices(
            @PathVariable(value = "resourceServicesId") Long resourceServicesId) {
        return commentsResourcesServicesServices.getCommentsResourcesServiceForResourceServiceId(resourceServicesId);
    }

    @GetMapping("/services/resourceservices/{resourceServicesId}/comments/{commentsRSId}")
    public ResponseEntity<CommentsResourceServicesDTO> getcommentsResourcesServicesById(
            @PathVariable(value = "resourceServicesId") Long resourceServicesId,
            @PathVariable(value = "commentsRSId") Long commentsRSId) {
        CommentsResourceServicesDTO commentsResourceServicesDTO = commentsResourcesServicesServices
                .getCommentsResourceServiceId(resourceServicesId, commentsRSId);

        return new ResponseEntity<>(commentsResourceServicesDTO, HttpStatus.OK);
    }

    @PutMapping("/services/resourceservices/{resourceServicesId}/comments/{commentsRSId}")
    public ResponseEntity<CommentsResourceServicesDTO> updatecommentsResourceService(
            @PathVariable(value = "resourceServicesId") Long resourceServicesId,
            @PathVariable(value = "commentsRSId") Long commentsSId,
            @Valid @RequestBody CommentsResourceServicesDTO commentsResourceServicesDTO) {
        CommentsResourceServicesDTO resourcesServicesUpdate = commentsResourcesServicesServices
                .updateCommentsResourceService(resourceServicesId, commentsSId, commentsResourceServicesDTO);
        return new ResponseEntity<>(resourcesServicesUpdate, HttpStatus.OK);

    }

    @DeleteMapping("/services/resourceservices/{resourceServicesId}/comments/{commentsRSId}")
    public ResponseEntity<String> deletecommentsResourcesServices(
            @PathVariable(value = "resourceServicesId") Long resourceServicesId,
            @PathVariable(value = "commentsRSId") Long commentsRSId) {
        commentsResourcesServicesServices.deleteCommentsResourceService(resourceServicesId, commentsRSId);
        return new ResponseEntity<>("Resource service  Delete succesfully", HttpStatus.OK);
    }

}
