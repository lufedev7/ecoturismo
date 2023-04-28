package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;

public interface ResourcesServicesServices {
    public ResourcesServicesDTO createResourceService(Long servicesId, ResourcesServicesDTO resourcesServicesDTO);
    public List<ResourcesServicesDTO> getResourcesServiceForServiceId(long servicesId);
    public ResourcesServicesDTO getResourceServiceId(Long idServices, Long idResourceServices);
    public ResourcesServicesDTO updateResourceService(Long servicesId, Long idResourceServices, ResourcesServicesDTO resourcesServicesDTO);
    public void deleteResourceService(Long servicesId, Long resourcesServicesId);
    public List<ResourcesServicesDTO> getAllResourceServices(int numberPage,int  measure, String orderBy, String sortDir);
}
