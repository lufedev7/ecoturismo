package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.TypesAttractivesDTO;

public interface TypeAttractivesServices {
    public TypesAttractivesDTO createTypeAttractives(TypesAttractivesDTO typeAttractiveTO);
    public List<TypesAttractivesDTO> getAllTypeAttractive();
    public TypesAttractivesDTO getTypeAttractiveById(Long idAttractive);
    public TypesAttractivesDTO updateTypeAttractive(Long idtypeAttractive, TypesAttractivesDTO typeAttractiveDTO);
    public void deleteTypeAttractive( Long typeAttractiveId);
}
