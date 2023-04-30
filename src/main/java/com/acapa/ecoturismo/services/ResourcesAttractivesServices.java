package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTO;
import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTOUse;

public interface ResourcesAttractivesServices {
    public ResourcesAttractivesDTOUse createResourceAttractives(Long attractivesId,
            ResourcesAttractivesDTOUse resourcesAttractivesDTO);

    public List<ResourcesAttractivesDTO> getResourcesAttractivesForAttractivesId(long attractivesId);

    public ResourcesAttractivesDTO getResourceAttractivesId(Long attractivesId, Long idResourcesAttractives);

    public ResourcesAttractivesDTOUse updateResourceAttractives(Long attractivesId, Long idResourcesAttractives,
            ResourcesAttractivesDTOUse resourcesAttractivesDTO);

    public void deleteResourceAttractives(Long attractivesId, Long resourcesattractivesId);

    public List<ResourcesAttractivesDTO> getAllResourceAttractives(int numberPage, int measure, String orderBy,
            String sortDir);
}
