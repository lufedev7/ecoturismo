package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.ServicesDTO;
import com.acapa.ecoturismo.dtos.ServicesDTOUse;

public interface ServicesServices {
    public ServicesDTOUse createServices(Long initiativeId, Long typeServiceId, ServicesDTOUse serviceDTO);

    public List<ServicesDTO> getserviceForInitiativeId(long initiativeId);

    public List<ServicesDTO> getAllservice();

    public ServicesDTO getServiceById(Long idInitiative, Long idservice);

    public ServicesDTOUse updateService(Long initiativeId, Long idService, ServicesDTOUse serviceDTO);

    public void deleteService(Long initiativeId, Long serviceId);

}
