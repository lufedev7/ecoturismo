
package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.VeredaDTO;
import com.acapa.ecoturismo.dtos.VeredaDTOUse;
import com.acapa.ecoturismo.entitys.Contact;
import com.acapa.ecoturismo.entitys.Organizations;
import com.acapa.ecoturismo.entitys.Vereda;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.ContactRepository;
import com.acapa.ecoturismo.repository.OrganizationsRepository;
import com.acapa.ecoturismo.repository.VeredaRepository;

@Service
public class VeredaServicesImpl implements VeredaServices {

    @Autowired
    private OrganizationsRepository organizationsRepository;

    @Autowired
    private VeredaRepository veredaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public VeredaDTOUse createVereda(Long organizationsId, Long contactId,
            VeredaDTOUse veredaDTO) {

        Vereda vereda = mapearEntityUse(veredaDTO);

        Organizations organizations = organizationsRepository.findById(organizationsId)
                .orElseThrow(() -> new ResourceNotFoundException("Esta  Organizations no existe con ", "id",
                        organizationsId));

        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Este Contacto no existe con ", "id", contactId));

        vereda.setContact(contact);
        vereda.setOrganizations(organizations);
        Vereda newVereda = veredaRepository.save(vereda);
        return mapearDTOUse(newVereda);
    }

    @Override
    public List<VeredaDTO> getVeredaForOrganizationsId(long organizationsId) {

        List<Vereda> vereda = veredaRepository.findByOrganizationsId(organizationsId);
        return vereda.stream().map(veredas -> mapearDTO(veredas)).collect(Collectors.toList());

    }

    @Override
    public VeredaDTO getVeredaById(Long idOrganization, Long idVereda) {

        Organizations organizations = organizationsRepository.findById(idOrganization)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Organizations", "id",
                        idOrganization));
        Vereda vereda = veredaRepository.findById(idVereda).orElseThrow(
                () -> new ResourceNotFoundException("Esta vereda no se encuentra registrada con ",
                        "id", idVereda));

        if (!vereda.getOrganizations().getId().equals(organizations.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La vereda no pertenece a la organización");
        }
        return mapearDTO(vereda);
    }

    @Override
    public VeredaDTOUse updateVereda(Long organizationsId, Long idVereda,
            VeredaDTOUse veredaDTO) {
        Organizations organizations = organizationsRepository.findById(organizationsId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Organizations", "id",
                        organizationsId));
        Vereda vereda = veredaRepository.findById(idVereda).orElseThrow(
                () -> new ResourceNotFoundException("Esta vereda no se encuentra registrada con ",
                        "id", idVereda));

        if (!vereda.getOrganizations().getId().equals(organizations.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La vereda no pertenece a la organización");
        }

        vereda.setVeredaName(veredaDTO.getVeredaName());
        vereda.setHabiNumVereda(veredaDTO.getHabiNumVereda());
        vereda.setCoorVereda(veredaDTO.getCoorVereda());

        Vereda veredaUpdate = veredaRepository.save(vereda);
        return mapearDTOUse(veredaUpdate);
    }

    @Override
    public void deleteVereda(Long organizationId, Long veredaId) {
        Organizations organizations = organizationsRepository.findById(organizationId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Organizations", "id",
                        organizationId));
        Vereda vereda = veredaRepository.findById(veredaId).orElseThrow(
                () -> new ResourceNotFoundException("Esta vereda no se encuentra registrada con ",
                        "id", veredaId));

        if (!vereda.getOrganizations().getId().equals(organizations.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La vereda no pertenece a la organización");
        }
        veredaRepository.delete(vereda);
    }

    private VeredaDTOUse mapearDTOUse(Vereda vereda) {
        return modelMapper.map(vereda, VeredaDTOUse.class);
    }

    private VeredaDTO mapearDTO(Vereda vereda) {
        return modelMapper.map(vereda, VeredaDTO.class);
    }

    private Vereda mapearEntityUse(VeredaDTOUse veredaDTO) {
        return modelMapper.map(veredaDTO, Vereda.class);
    }
}
