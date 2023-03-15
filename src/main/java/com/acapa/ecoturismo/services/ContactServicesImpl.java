package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.ContactDTO;
import com.acapa.ecoturismo.entitys.Contact;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.ContactRepository;


@Service
public class ContactServicesImpl implements contactServices{

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {

        Contact contact = mapearEntity(contactDTO);
        Contact newContact = contactRepository.save(contact);
        return mapearDTO(newContact);
    }

    @Override
    public List<ContactDTO> getAllContact() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map(cont -> mapearDTO(cont)).collect(Collectors.toList());
    }

    @Override
    public ContactDTO getContactById(Long idContact) {
        Contact contact = contactRepository.findById(idContact)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Contact", "id", idContact));
        return mapearDTO(contact);
    }

    @Override
    public ContactDTO updateContact(Long idContact, ContactDTO contactDTO) {
        Contact contact = contactRepository.findById(idContact)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Contact", "id", idContact));
        contact.setContactName(contactDTO.getContactName());
        contact.setAddresContact(contactDTO.getAddresContact());
        contact.setEmail(contactDTO.getEmail());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());
        contact.setPhoneNumber2(contactDTO.getPhoneNumber2());

        Contact updateContact = contactRepository.save(contact);
        return mapearDTO(updateContact);
    }

    @Override
    public void deleteContact(Long idContact) {

        Contact contact = contactRepository.findById(idContact)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Contact", "id", idContact));
        contactRepository.delete(contact);
    }
    private ContactDTO mapearDTO(Contact contact){
        return modelMapper.map(contact,ContactDTO.class);
    }
    private Contact mapearEntity(ContactDTO contactDTO){
        return modelMapper.map(contactDTO,Contact.class);
    }
}
