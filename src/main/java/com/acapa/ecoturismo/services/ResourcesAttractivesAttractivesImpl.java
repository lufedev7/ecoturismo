package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTO;
import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTOUse;
import com.acapa.ecoturismo.entitys.Attractives;
import com.acapa.ecoturismo.entitys.ResourcesAttractives;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.AttractivesRepository;
import com.acapa.ecoturismo.repository.ResourcesAttractivesRepository;

@Service
public class ResourcesAttractivesAttractivesImpl implements ResourcesAttractivesServices {

    @Autowired
    private ResourcesAttractivesRepository resourcesAttractivesRepository;
    @Autowired
    private AttractivesRepository attractivesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResourcesAttractivesDTOUse createResourceAttractives(Long attractivesId,
            ResourcesAttractivesDTOUse resourcesAttractivesDTO) {
        ResourcesAttractives resourcesAttractives = mapearEntity(resourcesAttractivesDTO);

        Attractives attractives = attractivesRepository.findById(attractivesId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Esta  Attractives no existe con ", "id", attractivesId));

        resourcesAttractives.setAttractive(attractives);
        ResourcesAttractives newResourcesAttractives = resourcesAttractivesRepository.save(resourcesAttractives);
        return mapearDTOUse(newResourcesAttractives);
    }

    @Override
    public List<ResourcesAttractivesDTO> getResourcesAttractivesForAttractivesId(long attractivesId) {
        List<ResourcesAttractives> resourcesAttractives = resourcesAttractivesRepository
                .findByAttractiveId(attractivesId);
        return resourcesAttractives.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public ResourcesAttractivesDTO getResourceAttractivesId(Long attractivesId, Long idResourcesAttractives) {
        Attractives attractives = attractivesRepository.findById(attractivesId)
                .orElseThrow(() -> new ResourceNotFoundException(" Este Atractivo", "id", attractivesId));
        ResourcesAttractives resourcesAttractives = resourcesAttractivesRepository.findById(idResourcesAttractives)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Este Recurso de atractivo no se encuentra registrada con ", "id", idResourcesAttractives));

        if (!resourcesAttractives.getAttractive().getId().equals(attractives.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La ResourcesAttractives no pertenece a la organización");
        }
        return mapearDTO(resourcesAttractives);
    }

    @Override
    public ResourcesAttractivesDTOUse updateResourceAttractives(Long attractivesId, Long idResourcesAttractives,
            ResourcesAttractivesDTOUse resourcesAttractivesDTO) {

        Attractives attractives = attractivesRepository.findById(attractivesId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Attractives", "id", attractivesId));
        ResourcesAttractives resourcesAttractives = resourcesAttractivesRepository.findById(idResourcesAttractives)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Esta ResourcesAttractives no se encuentra registrada con ", "id", idResourcesAttractives));

        if (!resourcesAttractives.getAttractive().getId().equals(attractives.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La ResourcesAttractives no pertenece a la organización");
        }

        resourcesAttractives.setNameResource(resourcesAttractivesDTO.getNameResource());
        resourcesAttractives.setDescription(resourcesAttractivesDTO.getDescription());
        resourcesAttractives.setLinkResource(resourcesAttractivesDTO.getLinkResource());
        resourcesAttractives.setTimeStamp(resourcesAttractivesDTO.getTimeStamp());
        resourcesAttractives.setTypeResource(resourcesAttractivesDTO.isTypeResource());

        ResourcesAttractives resourcesAttractivesUpdate = resourcesAttractivesRepository.save(resourcesAttractives);
        return mapearDTOUse(resourcesAttractivesUpdate);
    }

    @Override
    public void deleteResourceAttractives(Long attractivesId, Long resourcesattractivesId) {
        Attractives attractives = attractivesRepository.findById(attractivesId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Attractives", "id", attractivesId));
        ResourcesAttractives resourcesAttractives = resourcesAttractivesRepository.findById(resourcesattractivesId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Esta ResourcesAttractives no se encuentra registrada con ", "id", resourcesattractivesId));

        if (!resourcesAttractives.getAttractive().getId().equals(attractives.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El ResourcesAttractives no pertenece al  servicio");
        }
        resourcesAttractivesRepository.delete(resourcesAttractives);
    }

    private ResourcesAttractivesDTO mapearDTO(ResourcesAttractives resourcesAttractives) {
        return modelMapper.map(resourcesAttractives, ResourcesAttractivesDTO.class);
    }

    private ResourcesAttractivesDTOUse mapearDTOUse(ResourcesAttractives resourcesAttractives) {
        return modelMapper.map(resourcesAttractives, ResourcesAttractivesDTOUse.class);
    }

    private ResourcesAttractives mapearEntity(ResourcesAttractivesDTOUse resourcesAttractivesDTO) {
        return modelMapper.map(resourcesAttractivesDTO, ResourcesAttractives.class);
    }

    @Override
    public List<ResourcesAttractivesDTO> getAllResourceAttractives(int numberPage, int measure, String orderBy,
            String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending()
                : Sort.by(orderBy).descending();

        Pageable pageable = PageRequest.of(numberPage, measure, sort);
        Page<ResourcesAttractives> resourcesAttractives = resourcesAttractivesRepository.findAll(pageable);
        List<ResourcesAttractives> listResourcesAttractives = resourcesAttractives.getContent();

        return listResourcesAttractives.stream().map(this::mapearDTO)
                .collect(Collectors.toList());
    }
}
