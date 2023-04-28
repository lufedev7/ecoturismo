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

import com.acapa.ecoturismo.dtos.CommentsResourcesAttractivesDTO;
import com.acapa.ecoturismo.services.CommentsResourcesAttractivesServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class CommentsResourcesAttractivesControllers {

    @Autowired
    private CommentsResourcesAttractivesServices commentsResourcesAttractivesServices;

    @PostMapping("/attractives/post/resourceattractives/{resourceAttractivesId}/comments")
    public ResponseEntity<CommentsResourcesAttractivesDTO> saveCommentsResourcesAttractives(
            @PathVariable(value = "resourceAttractivesId") Long resourceAttractivesId,
            @Valid @RequestBody CommentsResourcesAttractivesDTO commentsResourcesAttractivesDTO) {
        return new ResponseEntity<>(
                commentsResourcesAttractivesServices.createCommentsResourceAttractives(resourceAttractivesId, commentsResourcesAttractivesDTO)
                , HttpStatus.CREATED);
    }

    @GetMapping("/attractives/resourceattractives/{resourceAttractivesId}/comments")
    public List<CommentsResourcesAttractivesDTO> listcommentsResourcesAttractivesByresourceAttractives(
            @PathVariable(value = "resourceAttractivesId") Long resourceAttractivesId) {
        return commentsResourcesAttractivesServices.getCommentsResourcesAttractiveForResourceAttractiveId(resourceAttractivesId);
    }

    @GetMapping("/attractives/resourceattractives/{resourceAttractivesId}/comments/{commentsRAId}")
    public ResponseEntity<CommentsResourcesAttractivesDTO> getcommentsResourcesAttractivesById(
            @PathVariable(value = "resourceAttractivesId") Long resourceAttractivesId,
            @PathVariable(value = "commentsRAId") Long commentsRAId) {
        CommentsResourcesAttractivesDTO commentsResourcesAttractivesDTO = commentsResourcesAttractivesServices
                .getCommentsResourceAttractiveId(resourceAttractivesId, commentsRAId);

        return new ResponseEntity<>(commentsResourcesAttractivesDTO, HttpStatus.OK);
    }

    @PutMapping("/attractives/resourceattractives/{resourceAttractivesId}/comments/{commentsRAId}")
    public ResponseEntity<CommentsResourcesAttractivesDTO> updatecommentsResourceAttractives(
            @PathVariable(value = "resourceAttractivesId") Long resourceAttractivesId,
            @PathVariable(value = "commentsRAId") Long commentsRAId,
            @Valid @RequestBody CommentsResourcesAttractivesDTO commentsResourcesAttractivesDTO) {
        CommentsResourcesAttractivesDTO resourcesAttractivesUpdate = commentsResourcesAttractivesServices
                .updateCommentsResourceAttractives(resourceAttractivesId, commentsRAId, commentsResourcesAttractivesDTO);
        return new ResponseEntity<>(resourcesAttractivesUpdate, HttpStatus.OK);

    }

    @DeleteMapping("/attractives/resourceattractives/{resourceAttractivesId}/comments/{commentsRAId}")
    public ResponseEntity<String> deletecommentsResourcesAttractives(
            @PathVariable(value = "resourceAttractivesId") Long resourceAttractivesId,
            @PathVariable(value = "commentsRAId") Long commentsRAId) {
        commentsResourcesAttractivesServices.deleteCommentsResourceAttractives(resourceAttractivesId, commentsRAId);
        return new ResponseEntity<>("Comments Resource Attractives  Delete succesfully", HttpStatus.OK);
    }
}
