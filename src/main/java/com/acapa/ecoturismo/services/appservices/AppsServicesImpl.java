package com.acapa.ecoturismo.services.appservices;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTO;
import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;
import com.acapa.ecoturismo.dtos.appcontrollerdto.AppResponseDTO;
import com.acapa.ecoturismo.entitys.ResourcesAttractives;
import com.acapa.ecoturismo.entitys.ResourcesServices;
import com.acapa.ecoturismo.repository.ResourcesAttractivesRepository;
import com.acapa.ecoturismo.repository.ResourcesServicesRepository;

@Service
public class AppsServicesImpl implements AppServices {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ResourcesServicesRepository resourcesServicesRepository;
    @Autowired
    private ResourcesAttractivesRepository resourcesAttractivesRepository;

    @Override
    public AppResponseDTO getpageFeed(int numberPage, int measure, String orderBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending()
                : Sort.by(orderBy).descending();

        Pageable pageable = PageRequest.of(numberPage, measure, sort);

        // Services
        Page<ResourcesServices> resourcesServices = resourcesServicesRepository.findAll(pageable);
        List<ResourcesServices> listResourcesServices = resourcesServices.getContent();
        List<ResourcesServicesDTO> content = listResourcesServices.stream().map(this::mapearDTO)
                .collect(Collectors.toList());

        // Attractives
        Sort sortAttractives = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending()
                : Sort.by(orderBy).descending();

        Pageable pageableAttractives = PageRequest.of(numberPage, measure, sortAttractives);

        Page<ResourcesAttractives> resourcesAttractives = resourcesAttractivesRepository.findAll(pageableAttractives);
        List<ResourcesAttractives> listResourcesAtttratives = resourcesAttractives.getContent();
        List<ResourcesAttractivesDTO> contentAttratives = listResourcesAtttratives.stream()
                .map(this::mapearAttractivesDTO)
                .collect(Collectors.toList());

        AppResponseDTO appResponse = new AppResponseDTO();
        appResponse.setResourceServices(content);
        appResponse.setResourceAttractives(contentAttratives);

        appResponse.setNumPageServices(resourcesServices.getNumber());
        appResponse.setSizePageServices(resourcesServices.getSize());
        appResponse.setTotalElementServices(resourcesServices.getTotalElements());
        appResponse.setTotalPageServices(resourcesServices.getTotalPages());
        appResponse.setLateastServices(resourcesServices.isLast());

        appResponse.setNumPageAttractives(resourcesAttractives.getNumber());
        appResponse.setSizePageAttractives(resourcesAttractives.getSize());
        appResponse.setTotalElementAttractives(resourcesAttractives.getTotalElements());
        appResponse.setTotalPageAttractives(resourcesAttractives.getTotalPages());
        appResponse.setLateastAttractives(resourcesAttractives.isLast());

        return appResponse;
    }

    @Override
    public List<ResourcesServicesDTO> getAllResourceServices() {

        List<ResourcesServices> resourcesServices = resourcesServicesRepository.findAll();
        return resourcesServices.stream().map(this::mapearDTO).collect(Collectors.toList());

    }

    private ResourcesServicesDTO mapearDTO(ResourcesServices resourcesServices) {
        return modelMapper.map(resourcesServices, ResourcesServicesDTO.class);
    }

    private ResourcesAttractivesDTO mapearAttractivesDTO(ResourcesAttractives resourcesAttractives) {
        return modelMapper.map(resourcesAttractives, ResourcesAttractivesDTO.class);
    }

}
