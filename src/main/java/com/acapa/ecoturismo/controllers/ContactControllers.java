package com.acapa.ecoturismo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acapa.ecoturismo.dtos.ContactDTO;
import com.acapa.ecoturismo.services.contactServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contact")
public class ContactControllers {
    @Autowired
    private contactServices contactServices;
    @PostMapping
    public ResponseEntity<ContactDTO> saveContact(@RequestBody ContactDTO contactDTO) {
        return new ResponseEntity<>(contactServices.createContact(contactDTO), HttpStatus.CREATED);
    }

}
