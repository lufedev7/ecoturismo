package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTO;

public interface ResourcesAttractivesServices {
    public ResourcesAttractivesDTO createResourceAttractives(Long attractivesId, ResourcesAttractivesDTO resourcesAttractivesDTO);
    public List<ResourcesAttractivesDTO> getResourcesAttractivesForAttractivesId(long attractivesId);
    public ResourcesAttractivesDTO getResourceAttractivesId(Long attractivesId, Long idResourcesAttractives);
    public ResourcesAttractivesDTO updateResourceAttractives(Long attractivesId, Long idResourcesAttractives, ResourcesAttractivesDTO resourcesAttractivesDTO);
    public void deleteResourceAttractives(Long attractivesId, Long resourcesattractivesId);
    public List <ResourcesAttractivesDTO>getAllResourceAttractives(int numberPage, int measure, String orderBy, String sortDir);
}
