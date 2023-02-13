package com.acapa.ecoturismo.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.OrganizationsDTO;
import com.acapa.ecoturismo.entitys.Organizations;
import com.acapa.ecoturismo.repository.OrganizationsRepository;
@Service
public class OrganizationsServicesImpl implements OrganizationsServices{
    @Autowired
    private OrganizationsRepository organizationsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public OrganizationsDTO createOrganization(OrganizationsDTO organizationsDTO) {
        Organizations organizations = mapearEntity(organizationsDTO);
        Organizations newOrganizations = organizationsRepository.save(organizations);
        return  mapearDTO(newOrganizations);
    }
    private OrganizationsDTO mapearDTO(Organizations organizations){
            return modelMapper.map(organizations, OrganizationsDTO.class);
    }
    private Organizations mapearEntity(OrganizationsDTO organizationsDTO){
        return modelMapper.map(organizationsDTO, Organizations.class);
}
}
