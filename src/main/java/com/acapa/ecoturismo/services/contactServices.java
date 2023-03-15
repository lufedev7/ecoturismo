package com.acapa.ecoturismo.services;


import java.util.List;

import com.acapa.ecoturismo.dtos.ContactDTO;

public interface contactServices {
    
    public ContactDTO createContact(ContactDTO contactDTO);
    public List<ContactDTO>getAllContact();
    public ContactDTO getContactById( Long idContact);
    public ContactDTO updateContact( Long idContact, ContactDTO contactDTO);
    public void deleteContact( Long ContactId);
    
}
