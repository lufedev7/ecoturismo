package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.AttractivesDTO;

public interface AttractivesServices {
    public AttractivesDTO createAttractive(Long initiativeId,Long typeAttractiveId, AttractivesDTO attractiveDTO);
    public List<AttractivesDTO> getAttractiveForInitiativeId(long initiativeId);
    public AttractivesDTO getAttractiveById(Long idInitiative, Long idAttractive);
    public AttractivesDTO updateAttractive(Long initiativeId, Long idAttractive, AttractivesDTO attractiveDTO);
    public void deleteAttractive(Long initiativeId, Long attractiveId);
   
}
