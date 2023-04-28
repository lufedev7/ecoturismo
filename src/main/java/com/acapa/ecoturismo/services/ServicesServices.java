package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.ServicesDTO;
import com.acapa.ecoturismo.dtos.TypeServicesDTO;

public interface ServicesServices {
    public ServicesDTO createServices(Long initiativeId, Long typeServiceId, ServicesDTO serviceDTO);

    public List<ServicesDTO> getserviceForInitiativeId(long initiativeId);

    public ServicesDTO getServiceById(Long idInitiative, Long idservice);

    public ServicesDTO updateService(Long initiativeId, Long idService, ServicesDTO serviceDTO);

    public void deleteService(Long initiativeId, Long serviceId);

    public TypeServicesDTO prueba(Long initiativeId, Long typeServiceId, ServicesDTO serviceDTO);
}
