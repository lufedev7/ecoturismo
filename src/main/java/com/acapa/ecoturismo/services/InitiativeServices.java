package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.InitiativeDTO;

public interface InitiativeServices {
    public InitiativeDTO createInitiavive(Long veredaId,Long contactId, InitiativeDTO initiativeDTO);
    public List<InitiativeDTO>getInitiativeByVereda(long idVereda);
    public InitiativeDTO getInitiativeById(long idVereda,long idInitiative);
    public InitiativeDTO updateInitiative(long idVereda,long idInitiative,InitiativeDTO initiativeDTO);
    public void deleteInitiative(long idVereda,long idInitiative);

}
