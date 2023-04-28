package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.TypesAttractivesDTO;
import com.acapa.ecoturismo.dtos.TypesAttractivesDTOUse;

public interface TypeAttractivesServices {
    public TypesAttractivesDTOUse createTypeAttractives(TypesAttractivesDTOUse typeAttractiveTO);

    public List<TypesAttractivesDTO> getAllTypeAttractive();

    public TypesAttractivesDTO getTypeAttractiveById(Long idAttractive);

    public TypesAttractivesDTOUse updateTypeAttractive(Long idtypeAttractive, TypesAttractivesDTOUse typeAttractiveDTO);

    public void deleteTypeAttractive(Long typeAttractiveId);
}
