package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.TypeServicesDTO;
import com.acapa.ecoturismo.entitys.TypesServices;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.TypesServicesRepository;
@Service
public class TypeServicesServicesImpl implements TypeServicesServices{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TypesServicesRepository typesServicesRepository;
    @Override
    public TypeServicesDTO createTypeService(TypeServicesDTO typeServiceDTO) {
        TypesServices typesServices = mapearEntity(typeServiceDTO);
        TypesServices newTypesServices = typesServicesRepository.save(typesServices);
        return mapearDTO(newTypesServices);
    }

    @Override
    public List<TypeServicesDTO> getAllTypeService() {
        List<TypesServices> typesServices = typesServicesRepository.findAll();
        return typesServices.stream().map(tps -> mapearDTO(tps)).collect(Collectors.toList());
    }

    @Override
    public TypeServicesDTO getTypeServiceById(Long idService) {
        TypesServices typesServices = typesServicesRepository.findById(idService)
        .orElseThrow(() -> new ResourceNotFoundException(" it's TypesServices", "id", idService));
        return mapearDTO(typesServices);
    }

    @Override
    public TypeServicesDTO updateTypeService(Long idtypeService, TypeServicesDTO typeServiceDTO) {
        TypesServices typesServices = typesServicesRepository.findById(idtypeService)
        .orElseThrow(() -> new ResourceNotFoundException(" it's TypesServices", "id", idtypeService));
        typesServices.setDescriptionTypeServices(typeServiceDTO.getDescriptionTypeServices());
        typesServices.setServicesType(typeServiceDTO.getServicesType());

        TypesServices updateTypesServices = typesServicesRepository.save(typesServices);
        return mapearDTO(updateTypesServices);
    }

    @Override
    public void deleteTypeService(Long typeServiceId) {
        TypesServices typesServices = typesServicesRepository.findById(typeServiceId)
        .orElseThrow(() -> new ResourceNotFoundException(" it's TypesServices", "id", typeServiceId));
        typesServicesRepository.delete(typesServices);
    }
    private TypeServicesDTO mapearDTO(TypesServices typesServices){
        return modelMapper.map(typesServices,TypeServicesDTO.class);
    }
    private TypesServices mapearEntity(TypeServicesDTO typesServicesDTO){
        return modelMapper.map(typesServicesDTO,TypesServices.class);
    }
}
