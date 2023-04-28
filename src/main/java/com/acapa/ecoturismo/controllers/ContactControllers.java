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

import com.acapa.ecoturismo.dtos.ContactDTO;
import com.acapa.ecoturismo.dtos.ContactDTOUse;
import com.acapa.ecoturismo.services.contactServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contact")
public class ContactControllers {
    @Autowired
    private contactServices contactServices;

    @PostMapping
    public ResponseEntity<ContactDTOUse> saveContact(@RequestBody ContactDTOUse contactDTO) {
        return new ResponseEntity<>(contactServices.createContact(contactDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ContactDTO> getAllContacts() {
        return contactServices.getAllContact();
    }

    @GetMapping("/{idContact}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable(name = "idContact") long idContact) {
        return ResponseEntity.ok(contactServices.getContactById(idContact));
    }

    @PutMapping("/{idContact}")
    public ResponseEntity<ContactDTOUse> updateContact(@Valid @RequestBody ContactDTOUse contactDTO,
            @PathVariable(name = "idContact") long idContact) {
        return new ResponseEntity<>(contactServices.updateContact(idContact, contactDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{idContact}")
    public ResponseEntity<String> deleteContact(@PathVariable(name = "idContact") long idContact) {
        contactServices.deleteContact(idContact);
        return new ResponseEntity<>("Contacto eliminado correctamente", HttpStatus.OK);
    }
}
