package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.ContactDTO;
import com.acapa.ecoturismo.dtos.ContactDTOUse;

public interface contactServices {

    public ContactDTOUse createContact(ContactDTOUse contactDTO);

    public List<ContactDTO> getAllContact();

    public ContactDTO getContactById(Long idContact);

    public ContactDTOUse updateContact(Long idContact, ContactDTOUse contactDTO);

    public void deleteContact(Long ContactId);

}
