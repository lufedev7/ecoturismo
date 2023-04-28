package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.AttractivesDTO;
import com.acapa.ecoturismo.dtos.AttractivesDTOUse;

public interface AttractivesServices {
    public AttractivesDTOUse createAttractive(Long initiativeId, Long typeAttractiveId,
            AttractivesDTOUse attractiveDTO);

    public List<AttractivesDTO> getAttractiveForInitiativeId(long initiativeId);

    public AttractivesDTO getAttractiveById(Long idInitiative, Long idAttractive);

    public AttractivesDTOUse updateAttractive(Long initiativeId, Long idAttractive, AttractivesDTOUse attractiveDTO);

    public void deleteAttractive(Long initiativeId, Long attractiveId);

    public List<AttractivesDTO> getAllAttractives();

}
