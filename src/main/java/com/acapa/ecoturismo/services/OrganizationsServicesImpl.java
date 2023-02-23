package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.OrganizationsDTO;
import com.acapa.ecoturismo.dtos.OrganizationsResponse;
import com.acapa.ecoturismo.entitys.Organizations;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
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

    @Override
    public OrganizationsResponse getOrganization(int numberPage, int measure, String orderBy, String sortDir) {
    Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() :
    Sort.by(orderBy).descending();

    Pageable pageable = PageRequest.of(numberPage,measure,sort);
    Page<Organizations> organizations = organizationsRepository.findAll(pageable);

    List <Organizations> listOrganizations = organizations.getContent();
    List <OrganizationsDTO> content = listOrganizations.stream().map(organization -> mapearDTO(organization)).
    collect(Collectors.toList());

    OrganizationsResponse organizationsResponse = new OrganizationsResponse();

    organizationsResponse.setContent(content);
    organizationsResponse.setNumPage(organizations.getNumber());
    organizationsResponse.setSizePage(organizations.getSize());
    organizationsResponse.setTotalElement(organizations.getTotalElements());
    organizationsResponse.setTotalPage(organizations.getTotalPages());
    organizationsResponse.setLateast(organizations.isLast());
        return organizationsResponse;

    }
    private OrganizationsDTO mapearDTO(Organizations organizations){
        return modelMapper.map(organizations, OrganizationsDTO.class);
}
private Organizations mapearEntity(OrganizationsDTO organizationsDTO){
    return modelMapper.map(organizationsDTO, Organizations.class);
}

@Override
public OrganizationsDTO updateOrganizacion(OrganizationsDTO organizationsDTO, long id) {
    Organizations organizations = organizationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Publication", "id", id));

        organizations.setOrganizationName(organizationsDTO.getOrganizationName());
        organizations.setOrganizationAddress(organizationsDTO.getOrganizationAddress());
        organizations.setOrganizationFacebook(organizationsDTO.getOrganizationFacebook());
        organizations.setOrganizationInstagram(organizationsDTO.getOrganizationInstagram());
        organizations.setOrganizationLocation(organizationsDTO.getOrganizationLocation());
        organizations.setOrganizationLogo(organizationsDTO.getOrganizationLogo());
        organizations.setOrganizationMision(organizationsDTO.getOrganizationMision());
        organizations.setOrganizationPhone(organizationsDTO.getOrganizationPhone());
        organizations.setOrganizationVision(organizationsDTO.getOrganizationVision());
        organizations.setOrganizationWebSite(organizationsDTO.getOrganizationWebSite());
        organizations.setOrganizationYoutube(organizationsDTO.getOrganizationYoutube());
        Organizations updateOrganizations = organizationsRepository.save(organizations);

        return mapearDTO(updateOrganizations);

}

@Override
public void deleteOrganization(long id) {
    Organizations organizations = organizationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Publication", "id", id));
    organizationsRepository.delete(organizations);

}

@Override
public OrganizationsDTO getOrganizationsById(long id) {
    Organizations organizations = organizationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Publication", "id", id));
    return mapearDTO(organizations);
}
}
