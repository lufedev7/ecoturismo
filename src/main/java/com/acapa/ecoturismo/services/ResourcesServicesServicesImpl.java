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

import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;
import com.acapa.ecoturismo.dtos.ResourcesServicesUseDTO;
import com.acapa.ecoturismo.entitys.ResourcesServices;
import com.acapa.ecoturismo.entitys.Services;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.ResourcesServicesRepository;
import com.acapa.ecoturismo.repository.ServicesRepository;

@Service
public class ResourcesServicesServicesImpl implements ResourcesServicesServices {
    @Autowired
    private ResourcesServicesRepository resourcesServicesRepository;
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResourcesServicesUseDTO createResourceService(Long servicesId,
            ResourcesServicesUseDTO resourcesServicesDTO) {
        ResourcesServices resourcesServices = mapearEntity(resourcesServicesDTO);

        Services services = servicesRepository.findById(servicesId)
                .orElseThrow(() -> new ResourceNotFoundException("Esta  Services no existe con ", "id", servicesId));

        resourcesServices.setServices(services);
        ResourcesServices newResourcesServices = resourcesServicesRepository.save(resourcesServices);
        return mapearDTOUse(newResourcesServices);
    }

    @Override
    public List<ResourcesServicesDTO> getResourcesServiceForServiceId(long servicesId) {
        List<ResourcesServices> resourcesServices = resourcesServicesRepository.findByServicesId(servicesId);
        return resourcesServices.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public ResourcesServicesDTO getResourceServiceId(Long idServices, Long idResourceServices) {
        Services services = servicesRepository.findById(idServices)
                .orElseThrow(() -> new ResourceNotFoundException(" Este Services", "id", idServices));
        ResourcesServices resourcesServices = resourcesServicesRepository.findById(idResourceServices).orElseThrow(
                () -> new ResourceNotFoundException("Este recurso de servicio no se encuentra registrada con ", "id",
                        idResourceServices));

        if (!resourcesServices.getServices().getId().equals(services.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "La ResourcesServices no pertenece a la organización");
        }
        return mapearDTO(resourcesServices);
    }

    @Override
    public ResourcesServicesUseDTO updateResourceService(Long servicesId, Long idResourceServices,
            ResourcesServicesUseDTO resourcesServicesDTO) {
        Services services = servicesRepository.findById(servicesId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Services", "id", servicesId));
        ResourcesServices resourcesServices = resourcesServicesRepository.findById(idResourceServices).orElseThrow(
                () -> new ResourceNotFoundException("Esta ResourcesServices no se encuentra registrada con ", "id",
                        idResourceServices));

        if (!resourcesServices.getServices().getId().equals(services.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "La ResourcesServices no pertenece a la organización");
        }

        resourcesServices.setNameResource(resourcesServicesDTO.getNameResource());
        resourcesServices.setDescription(resourcesServicesDTO.getDescription());
        resourcesServices.setUrl(resourcesServicesDTO.getUrl());
        resourcesServices.setTimeStamp(resourcesServicesDTO.getTimeStamp());
        resourcesServices.setTypeResource(resourcesServicesDTO.isTypeResource());

        ResourcesServices resourcesServicesUpdate = resourcesServicesRepository.save(resourcesServices);
        return mapearDTOUse(resourcesServicesUpdate);
    }

    @Override
    public void deleteResourceService(Long servicesId, Long resourcesServicesId) {
        Services services = servicesRepository.findById(servicesId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Services", "id", servicesId));
        ResourcesServices resourcesServices = resourcesServicesRepository.findById(resourcesServicesId).orElseThrow(
                () -> new ResourceNotFoundException("Esta ResourcesServices no se encuentra registrada con ", "id",
                        resourcesServicesId));

        if (!resourcesServices.getServices().getId().equals(services.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El ResourcesServices no pertenece al  servicio");
        }
        resourcesServicesRepository.delete(resourcesServices);
    }

    private ResourcesServicesDTO mapearDTO(ResourcesServices resourcesServices) {
        return modelMapper.map(resourcesServices, ResourcesServicesDTO.class);
    }

    private ResourcesServicesUseDTO mapearDTOUse(ResourcesServices resourcesServices) {
        return modelMapper.map(resourcesServices, ResourcesServicesUseDTO.class);
    }

    private ResourcesServices mapearEntity(ResourcesServicesUseDTO resourcesServicesDTO) {
        return modelMapper.map(resourcesServicesDTO, ResourcesServices.class);
    }

    @Override
    public List<ResourcesServicesDTO> getAllResourceServices(int numberPage, int measure, String orderBy,
            String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending()
                : Sort.by(orderBy).descending();

        Pageable pageable = PageRequest.of(numberPage, measure, sort);
        Page<ResourcesServices> resourcesServices = resourcesServicesRepository.findAll(pageable);
        List<ResourcesServices> listResourcesServices = resourcesServices.getContent();

        return listResourcesServices.stream().map(this::mapearDTO)
                .collect(Collectors.toList());
    }
}
