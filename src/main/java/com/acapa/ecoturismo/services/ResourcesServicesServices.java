package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;
import com.acapa.ecoturismo.dtos.ResourcesServicesUseDTO;

public interface ResourcesServicesServices {
    public ResourcesServicesUseDTO createResourceService(Long servicesId, ResourcesServicesUseDTO resourcesServicesDTO);

    public List<ResourcesServicesDTO> getResourcesServiceForServiceId(long servicesId);

    public ResourcesServicesDTO getResourceServiceId(Long idServices, Long idResourceServices);

    public ResourcesServicesUseDTO updateResourceService(Long servicesId, Long idResourceServices,
            ResourcesServicesUseDTO resourcesServicesDTO);

    public void deleteResourceService(Long servicesId, Long resourcesServicesId);

    public List<ResourcesServicesDTO> getAllResourceServices(int numberPage, int measure, String orderBy,
            String sortDir);
}
