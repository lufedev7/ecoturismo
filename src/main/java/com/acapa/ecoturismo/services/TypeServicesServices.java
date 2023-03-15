package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.TypeServicesDTO;

public interface TypeServicesServices {
    public TypeServicesDTO createTypeService(TypeServicesDTO typeServiceDTO);
    public List<TypeServicesDTO> getAllTypeService();
    public TypeServicesDTO getTypeServiceById(Long idService);
    public TypeServicesDTO updateTypeService(Long idtypeService, TypeServicesDTO typeServiceDTO);
    public void deleteTypeService( Long typeServiceId);
}
