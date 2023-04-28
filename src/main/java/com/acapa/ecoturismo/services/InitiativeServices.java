
package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.PruebaDTO;
import com.acapa.ecoturismo.dtos.pruebaDTOUse;

public interface InitiativeServices {
    public pruebaDTOUse createInitiavive(Long veredaId, Long contactId,
            pruebaDTOUse initiativeDTO);

    public List<PruebaDTO> getInitiativeByVereda(long idVereda);

    public List<PruebaDTO> getInitiativeByContact(long idContact);

    public PruebaDTO getInitiativeById(long idVereda, long idInitiative);

    public pruebaDTOUse updateInitiative(long idVereda, long idInitiative,
            pruebaDTOUse initiativeDTO);

    public void deleteInitiative(long idVereda, long idInitiative);

}
