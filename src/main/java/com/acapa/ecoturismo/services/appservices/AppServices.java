package com.acapa.ecoturismo.services.appservices;

import java.util.List;

import com.acapa.ecoturismo.dtos.AppsAttractives;
import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;
import com.acapa.ecoturismo.dtos.ServicesFeaturedDTO;
import com.acapa.ecoturismo.dtos.appResponseFeaturedDTO;
import com.acapa.ecoturismo.dtos.appcontrollerdto.AppResponseDTO;

public interface AppServices {
    public AppResponseDTO getpageFeed(int numberPage, int measure, String orderBy, String sortDir);

    public appResponseFeaturedDTO getFeaturedFeed();

    public List<AppsAttractives> getFeaturedAttractives();

    public List<ServicesFeaturedDTO> getFeaturedServices();

    public List<ResourcesServicesDTO> getAllResourceServices();
}
