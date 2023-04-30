package com.acapa.ecoturismo.services.appservices;

import java.util.List;

import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;
import com.acapa.ecoturismo.dtos.appcontrollerdto.AppResponseDTO;

public interface AppServices {
    public AppResponseDTO getpageFeed(int numberPage, int measure, String orderBy, String sortDir);

    public List<ResourcesServicesDTO> getAllResourceServices();
}
