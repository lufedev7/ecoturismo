
package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.PruebaDTO;
import com.acapa.ecoturismo.dtos.pruebaDTOUse;
import com.acapa.ecoturismo.entitys.Contact;
import com.acapa.ecoturismo.entitys.Vereda;
import com.acapa.ecoturismo.entitys.prueba;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.ContactRepository;
import com.acapa.ecoturismo.repository.InitiativeRepository;
import com.acapa.ecoturismo.repository.VeredaRepository;

@Service
public class InitiativeServicesImpl implements InitiativeServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VeredaRepository veredaRepository;

    @Autowired
    private InitiativeRepository initiativeRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public pruebaDTOUse createInitiavive(Long veredaId, Long contactId,
            pruebaDTOUse initiativeDTO) {
        prueba initiative = mapearEntityUse(initiativeDTO);

        Vereda vereda = veredaRepository.findById(veredaId)
                .orElseThrow(() -> new ResourceNotFoundException("Esta  vereda no existe con ", "id", veredaId));

        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Este Contacto no existe con ", "id", contactId));

        initiative.setContact(contact);
        initiative.setVereda(vereda);
        prueba newInitiative = initiativeRepository.save(initiative);
        return mapearDTOUse(newInitiative);
    }

    @Override
    public List<PruebaDTO> getInitiativeByVereda(long idVereda) {

        List<prueba> initiative = initiativeRepository.findByVeredaId(idVereda);
        return initiative.stream().map(initiatives -> mapearDTO(initiatives)).collect(Collectors.toList());

    }

    @Override
    public PruebaDTO getInitiativeById(long idVereda, long idInitiative) {
        Vereda vereda = veredaRepository.findById(idVereda)
                .orElseThrow(() -> new ResourceNotFoundException(" Esta vereda", "id",
                        idVereda));
        prueba initiative = initiativeRepository.findById(idInitiative)
                .orElseThrow(() -> new ResourceNotFoundException("La iniciativa no se encuentra registrada con ",
                        "id",
                        idInitiative));

        if (!initiative.getVereda().getId().equals(vereda.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "Esta Inicitaiva no pertenece a la Vereda");
        }

        return mapearDTO(initiative);
    }

    @Override
    public pruebaDTOUse updateInitiative(long idVereda, long idInitiative,
            pruebaDTOUse initiativeDTO) {

        Vereda vereda = veredaRepository.findById(idVereda)
                .orElseThrow(() -> new ResourceNotFoundException(" it's vereda", "id",
                        idVereda));
        prueba initiative = initiativeRepository.findById(idInitiative)
                .orElseThrow(() -> new ResourceNotFoundException("Esta iniciativa no se encuentra registrada con ",
                        "id", idInitiative));

        if (!initiative.getVereda().getId().equals(vereda.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La Inicitaiva no pertenece a la Vereda");
        }

        initiative.setInitiativeDescription(initiativeDTO.getInitiativeDescription());
        initiative.setInitiativeMision(initiativeDTO.getInitiativeMision());
        initiative.setInitiativeName(initiativeDTO.getInitiativeName());
        initiative.setInitiativeObject(initiativeDTO.getInitiativeObject());
        prueba initiativeUpdate = initiativeRepository.save(initiative);
        return mapearDTOUse(initiativeUpdate);
    }

    @Override
    public void deleteInitiative(long idVereda, long idInitiative) {
        Vereda vereda = veredaRepository.findById(idVereda)

                .orElseThrow(() -> new ResourceNotFoundException(" it's vereda", "id",
                        idVereda));
        prueba initiative = initiativeRepository.findById(idInitiative)
                .orElseThrow(() -> new ResourceNotFoundException("Esta iniciativa no se encuentra registrada con ",
                        "id", idInitiative));

        if (!initiative.getVereda().getId().equals(vereda.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La Inicitaiva no pertenece a la Vereda");
        }

        initiativeRepository.delete(initiative);
    }

    @Override
    public List<PruebaDTO> getInitiativeByContact(long idContact) {
        List<prueba> initiative = initiativeRepository.findByContactId(idContact);
        return initiative.stream().map(initiatives -> mapearDTO(initiatives)).collect(Collectors.toList());
    }

    private PruebaDTO mapearDTO(prueba initiative) {
        return modelMapper.map(initiative, PruebaDTO.class);
    }

    private pruebaDTOUse mapearDTOUse(prueba initiative) {
        return modelMapper.map(initiative, pruebaDTOUse.class);
    }

    private prueba mapearEntityUse(pruebaDTOUse initiativeDTO) {
        return modelMapper.map(initiativeDTO, prueba.class);
    }

    @Override
    public List<PruebaDTO> getAllInitiativestives() {
        List<prueba> initiatives = initiativeRepository.findAll();
        return initiatives.stream().map(cont -> mapearDTO(cont)).collect(Collectors.toList());
    }

}
