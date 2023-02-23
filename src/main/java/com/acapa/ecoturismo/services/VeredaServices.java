package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.VeredaDTO;
//
public interface VeredaServices {
    public VeredaDTO createVereda(Long organizationsId,Long contactId, VeredaDTO veredaDTO);
    public List<VeredaDTO> getVeredaForOrganizationsId(long organizationsId);
    public VeredaDTO getVeredaById(Long idOrganization, Long idVereda);
    public VeredaDTO updateVereda(Long organizationsId, Long idVereda, VeredaDTO veredaDTO);
    public void deleteVereda(Long organizationId, Long veredaId);
    
}
