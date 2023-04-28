
package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.VeredaDTO;
import com.acapa.ecoturismo.dtos.VeredaDTOUse;

public interface VeredaServices {
    public VeredaDTOUse createVereda(Long organizationsId, Long contactId,
            VeredaDTOUse veredaDTO);

    public List<VeredaDTO> getVeredaForOrganizationsId(long organizationsId);

    public VeredaDTO getVeredaById(Long idOrganization, Long idVereda);

    public VeredaDTOUse updateVereda(Long organizationsId, Long idVereda,
            VeredaDTOUse veredaDTO);

    public void deleteVereda(Long organizationId, Long veredaId);

}
