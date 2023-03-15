package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.InitiativeDTO;
import com.acapa.ecoturismo.entitys.Contact;
import com.acapa.ecoturismo.entitys.Initiative;
import com.acapa.ecoturismo.entitys.Vereda;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.ContactRepository;
import com.acapa.ecoturismo.repository.InitiativeRepository;
import com.acapa.ecoturismo.repository.VeredaRepository;
@Service
public class InitiativeServicesImpl implements InitiativeServices{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private VeredaRepository veredaRepository;
    @Autowired
    private InitiativeRepository initiativeRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public InitiativeDTO createInitiavive(Long veredaId, Long contactId, InitiativeDTO initiativeDTO) {
        Initiative initiative = mapearEntity(initiativeDTO);

        Vereda vereda = veredaRepository.findById(veredaId)
        .orElseThrow(() -> new ResourceNotFoundException("Esta  vereda no existe con ", "id", veredaId));

        Contact contact = contactRepository.findById(contactId)
        .orElseThrow(() -> new ResourceNotFoundException("Este Contacto no existe con ", "id", contactId));

        initiative.setContact(contact);
        initiative.setVereda(vereda);
        Initiative newInitiative = initiativeRepository.save(initiative);
        return mapearDTO(newInitiative);
    }

    @Override
    public List<InitiativeDTO> getInitiativeByVereda(long idVereda) {

        List<Initiative> initiative = initiativeRepository.findByVeredaId(idVereda);
        return  initiative.stream().map(initiatives -> mapearDTO(initiatives)).collect(Collectors.toList());

    }

    @Override
    public InitiativeDTO getInitiativeById(long idVereda, long idInitiative) {
        Vereda vereda = veredaRepository.findById(idVereda)
        .orElseThrow(() -> new ResourceNotFoundException(" Esta vereda", "id", idVereda));
        Initiative initiative = initiativeRepository.findById(idInitiative).
        orElseThrow(() -> new ResourceNotFoundException("La iniciativa no se encuentra registrada con ", "id", idInitiative));


        if(!initiative.getVereda().getId().equals(vereda.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Esta Inicitaiva no pertenece a la Vereda");
        }
        return mapearDTO(initiative);
    }

    @Override
    public InitiativeDTO updateInitiative(long idVereda, long idInitiative, InitiativeDTO initiativeDTO) {

        Vereda vereda = veredaRepository.findById(idVereda)
        .orElseThrow(() -> new ResourceNotFoundException(" it's vereda", "id", idVereda));
        Initiative initiative = initiativeRepository.findById(idInitiative).
        orElseThrow(() -> new ResourceNotFoundException("Esta iniciativa no se encuentra registrada con ", "id", idInitiative));


        if(!initiative.getVereda().getId().equals(vereda.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"La Inicitaiva no pertenece a la Vereda");
        }

        initiative.setInitiativeDescription(initiativeDTO.getInitiativeDescription());
        initiative.setInitiativeMision(initiativeDTO.getInitiativeMision());
        initiative.setInitiativeName(initiativeDTO.getInitiativeName());
        initiative.setInitiativeObject(initiativeDTO.getInitiativeObject());
        Initiative initiativeUpdate = initiativeRepository.save(initiative);
        return mapearDTO(initiativeUpdate);

    }

    @Override
    public void deleteInitiative(long idVereda, long idInitiative) {
        Vereda vereda = veredaRepository.findById(idVereda)
        .orElseThrow(() -> new ResourceNotFoundException(" it's vereda", "id", idVereda));
        Initiative initiative = initiativeRepository.findById(idInitiative).
        orElseThrow(() -> new ResourceNotFoundException("Esta iniciativa no se encuentra registrada con ", "id", idInitiative));


        if(!initiative.getVereda().getId().equals(vereda.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"La Inicitaiva no pertenece a la Vereda");
        }
        initiativeRepository.delete(initiative);
    }
    private InitiativeDTO mapearDTO(Initiative initiative){
        return modelMapper.map(initiative,InitiativeDTO.class);
    }
    private Initiative mapearEntity(InitiativeDTO initiativeDTO){
        return modelMapper.map(initiativeDTO,Initiative.class);
    }

}
