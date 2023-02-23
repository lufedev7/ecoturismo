package com.acapa.ecoturismo.services;

import com.acapa.ecoturismo.dtos.OrganizationsDTO;
import com.acapa.ecoturismo.dtos.OrganizationsResponse;

public interface OrganizationsServices {
    public OrganizationsDTO createOrganization(OrganizationsDTO organizationsDTO);
    public OrganizationsResponse getOrganization(int numberPage,int measure, String orderBy,String sortDir);
    public OrganizationsDTO updateOrganizacion(OrganizationsDTO organizationsDTO, long id);
    public OrganizationsDTO getOrganizationsById(long id);
    public void deleteOrganization(long id);
}
