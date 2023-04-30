package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.TypeServicesDTO;
import com.acapa.ecoturismo.dtos.TypeServicesDTOUse;

public interface TypeServicesServices {
    public TypeServicesDTOUse createTypeService(TypeServicesDTOUse typeServiceDTO);

    public List<TypeServicesDTO> getAllTypeService();

    public TypeServicesDTO getTypeServiceById(Long idService);

    public TypeServicesDTOUse updateTypeService(Long idtypeService, TypeServicesDTOUse typeServiceDTO);

    public void deleteTypeService(Long typeServiceId);
}
