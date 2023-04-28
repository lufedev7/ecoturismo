package com.acapa.ecoturismo.services;

import com.acapa.ecoturismo.dtos.OrganizationsDTO;
import com.acapa.ecoturismo.dtos.OrganizationsResponse;
import com.acapa.ecoturismo.dtos.OrganizationsDTOuse;

public interface OrganizationsServices {
    public OrganizationsDTOuse createOrganization(OrganizationsDTOuse organizationsDTO);
    public OrganizationsResponse getOrganization(int numberPage,int measure, String orderBy,String sortDir);
    public OrganizationsDTO updateOrganizacion(OrganizationsDTO organizationsDTO, long id);
    public OrganizationsDTO getOrganizationsById(long id);
    public void deleteOrganization(long id);
}
