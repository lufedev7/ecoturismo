package com.acapa.ecoturismo.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.ContactDTO;
import com.acapa.ecoturismo.entitys.Contact;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllContact'");
    }

    @Override
    public ContactDTO getContactById(Long idContact) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContactById'");
    }

    @Override
    public ContactDTO updateContact(Long idVereda, ContactDTO contactDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateContact'");
    }

    @Override
    public void deleteContact(Long ContactId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteContact'");
    }
    private ContactDTO mapearDTO(Contact contact){
        return modelMapper.map(contact,ContactDTO.class);
    }
    private Contact mapearEntity(ContactDTO contactDTO){
        return modelMapper.map(contactDTO,Contact.class);
    }
}
