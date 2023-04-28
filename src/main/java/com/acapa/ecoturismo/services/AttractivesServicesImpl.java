package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.AttractivesDTO;
import com.acapa.ecoturismo.entitys.Attractives;
import com.acapa.ecoturismo.entitys.Initiative;
import com.acapa.ecoturismo.entitys.TypesAttractives;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.AttractivesRepository;
import com.acapa.ecoturismo.repository.InitiativeRepository;
import com.acapa.ecoturismo.repository.TypesAttractivesRepository;

@Service
public class AttractivesServicesImpl implements AttractivesServices {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AttractivesRepository attractivesRepository;
    @Autowired
    private InitiativeRepository initiativeRepository;
    @Autowired
    private TypesAttractivesRepository typesAttractivesRepository;

    @Override
    public AttractivesDTO createAttractive(Long initiativeId, Long typeAttractiveId, AttractivesDTO attractiveDTO) {
        Attractives attractives = mapearEntity(attractiveDTO);
        /*
         * Initiative inittiatives = initiativeRepository.findById(initiativeId)
         * .orElseThrow(() -> new
         * ResourceNotFoundException("Esta  Initiatives no existe con ", "id",
         * initiativeId));
         * 
         */ TypesAttractives typeAttractive = typesAttractivesRepository.findById(typeAttractiveId)
                .orElseThrow(() -> new ResourceNotFoundException("Este TypeAttractiveo no existe con ", "id",
                        typeAttractiveId));

        attractives.setTypesAttractive(typeAttractive);
        // attractives.setInitiative(inittiatives);
        Attractives newAttractives = attractivesRepository.save(attractives);
        return mapearDTO(newAttractives);

    }

    @Override
    public List<AttractivesDTO> getAttractiveForInitiativeId(long initiativeId) {

        // List<Attractives> attractives =
        // attractivesRepository.findByInitiativeId(initiativeId);
        return null; // attractives.stream().map(veredas ->
                     // mapearDTO(veredas)).collect(Collectors.toList());
    }

    @Override
    public AttractivesDTO getAttractiveById(Long idInitiative, Long idAttractive) {
        /*
         * Initiative initiatives = initiativeRepository.findById(idInitiative)
         * .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id",
         * idInitiative));
         */
        Attractives attractive = attractivesRepository.findById(idAttractive)
                .orElseThrow(() -> new ResourceNotFoundException("Este atractivo no se encuentra registrada con ", "id",
                        idAttractive));

        /*
         * if(!attractive.getInitiative().getId().equals(initiatives.getId())){
         * throw new BlogAppException(HttpStatus.
         * BAD_REQUEST,"el atractivo no pertenece a la iniciativa");
         * }
         */
        return mapearDTO(attractive);
    }

    @Override
    public AttractivesDTO updateAttractive(Long initiativeId, Long idAttractive, AttractivesDTO attractiveDTO) {

        /*
         * Initiative initiatives = initiativeRepository.findById(initiativeId)
         * .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id",
         * initiativeId));
         */
        Attractives attractive = attractivesRepository.findById(idAttractive).orElseThrow(
                () -> new ResourceNotFoundException("Esta vereda no se encuentra registrada con ", "id", idAttractive));

        /*
         * if(!attractive.getInitiative().getId().equals(initiatives.getId())){
         * throw new BlogAppException(HttpStatus.
         * BAD_REQUEST,"La vereda no pertenece a la organización");
         * }
         */
        attractive.setNameAttractive(attractiveDTO.getNameAttractive());
        attractive.setDescriptionAttractive(attractiveDTO.getDescriptionAttractive());

        Attractives attractivesUpdate = attractivesRepository.save(attractive);
        return mapearDTO(attractivesUpdate);
    }

    @Override
    public void deleteAttractive(Long initiativeId, Long attractiveId) {

        /*
         * Initiative initiatives = initiativeRepository.findById(initiativeId)
         * .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id",
         * initiativeId));
         */
        Attractives attractive = attractivesRepository.findById(attractiveId).orElseThrow(
                () -> new ResourceNotFoundException("Esta vereda no se encuentra registrada con ", "id", attractiveId));

        /*
         * if(!attractive.getInitiative().getId().equals(initiatives.getId())){
         * throw new BlogAppException(HttpStatus.
         * BAD_REQUEST,"La vereda no pertenece a la organización");
         * }
         */
        attractivesRepository.delete(attractive);
    }

    private AttractivesDTO mapearDTO(Attractives attractives) {
        return modelMapper.map(attractives, AttractivesDTO.class);
    }

    private Attractives mapearEntity(AttractivesDTO attractivesDTO) {
        return modelMapper.map(attractivesDTO, Attractives.class);
    }

}
