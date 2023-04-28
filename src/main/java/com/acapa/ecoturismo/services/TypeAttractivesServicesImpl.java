package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.TypesAttractivesDTO;
import com.acapa.ecoturismo.dtos.TypesAttractivesDTOUse;
import com.acapa.ecoturismo.entitys.TypesAttractives;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.TypesAttractivesRepository;

@Service
public class TypeAttractivesServicesImpl implements TypeAttractivesServices {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TypesAttractivesRepository typesAttractivesRepository;

    @Override
    public TypesAttractivesDTOUse createTypeAttractives(TypesAttractivesDTOUse typeAttractiveTO) {

        TypesAttractives typesAttractives = mapearEntity(typeAttractiveTO);
        TypesAttractives newTypesAttractives = typesAttractivesRepository.save(typesAttractives);
        return mapearDTOUse(newTypesAttractives);
    }

    @Override
    public List<TypesAttractivesDTO> getAllTypeAttractive() {
        List<TypesAttractives> typesAttractives = typesAttractivesRepository.findAll();
        return typesAttractives.stream().map(tpa -> mapearDTO(tpa)).collect(Collectors.toList());
    }

    @Override
    public TypesAttractivesDTO getTypeAttractiveById(Long idAttractive) {
        TypesAttractives typesAttractives = typesAttractivesRepository.findById(idAttractive)
                .orElseThrow(() -> new ResourceNotFoundException(" it's TypesAttractives", "id", idAttractive));
        return mapearDTO(typesAttractives);
    }

    @Override
    public TypesAttractivesDTOUse updateTypeAttractive(Long idtypeAttractive,
            TypesAttractivesDTOUse typeAttractiveDTO) {

        TypesAttractives typesAttractives = typesAttractivesRepository.findById(idtypeAttractive)
                .orElseThrow(() -> new ResourceNotFoundException(" it's TypesAttractives", "id", idtypeAttractive));

        typesAttractives.setDescriptionType(typeAttractiveDTO.getDescriptionType());
        typesAttractives.setTypeAttractives(typeAttractiveDTO.getTypeAttractives());

        TypesAttractives updateTypesAttractives = typesAttractivesRepository.save(typesAttractives);
        return mapearDTOUse(updateTypesAttractives);
    }

    @Override
    public void deleteTypeAttractive(Long typeAttractiveId) {

        TypesAttractives typesAttractives = typesAttractivesRepository.findById(typeAttractiveId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's TypesAttractives", "id", typeAttractiveId));
        typesAttractivesRepository.delete(typesAttractives);
    }

    private TypesAttractivesDTOUse mapearDTOUse(TypesAttractives typesAttractives) {
        return modelMapper.map(typesAttractives, TypesAttractivesDTOUse.class);
    }

    private TypesAttractivesDTO mapearDTO(TypesAttractives typesAttractives) {
        return modelMapper.map(typesAttractives, TypesAttractivesDTO.class);
    }

    private TypesAttractives mapearEntity(TypesAttractivesDTOUse typesAttractivesDTO) {
        return modelMapper.map(typesAttractivesDTO, TypesAttractives.class);
    }
}
