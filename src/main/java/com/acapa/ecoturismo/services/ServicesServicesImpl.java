package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.ServicesDTO;
import com.acapa.ecoturismo.entitys.Initiative;
import com.acapa.ecoturismo.entitys.Services;
import com.acapa.ecoturismo.entitys.TypesServices;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.InitiativeRepository;
import com.acapa.ecoturismo.repository.ServicesRepository;
import com.acapa.ecoturismo.repository.TypesServicesRepository;

@Service
public class ServicesServicesImpl implements ServicesServices{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private TypesServicesRepository typesServicesRepository;
    @Autowired
    private InitiativeRepository initiativeRepository;

    @Override
    public ServicesDTO createServices(Long initiativeId, Long typeServiceId, ServicesDTO serviceDTO) {
        Services services = mapearEntity(serviceDTO);

        Initiative inittiatives = initiativeRepository.findById(initiativeId)
        .orElseThrow(() -> new ResourceNotFoundException("Esta  Initiatives no existe con ", "id", initiativeId));

        TypesServices typeService = typesServicesRepository.findById(typeServiceId)
        .orElseThrow(() -> new ResourceNotFoundException("Este TypeAttractiveo no existe con ", "id", typeServiceId));

        services.setTypesServices(typeService);
        services.setInitiative(inittiatives);
        Services newServices = servicesRepository.save(services);
        return mapearDTO(newServices);
    }

    @Override
    public List<ServicesDTO> getserviceForInitiativeId(long initiativeId) {
        List<Services> services = servicesRepository.findByInitiativeId(initiativeId);
        return  services.stream().map(service -> mapearDTO(service)).collect(Collectors.toList());
    }

    @Override
    public ServicesDTO getServiceById(Long idInitiative, Long idservice) {
        Initiative initiatives = initiativeRepository.findById(idInitiative)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id", idInitiative));
        Services service = servicesRepository.findById(idservice).
        orElseThrow(() -> new ResourceNotFoundException("Este Servicio no se encuentra registrada con ", "id", idservice));


        if(!service.getInitiative().getId().equals(initiatives.getId()) ){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"el servicio no pertenece a la iniciativa");
        }
        return mapearDTO(service);
    }

    @Override
    public ServicesDTO updateService(Long initiativeId, Long idService, ServicesDTO serviceDTO) {
        Initiative initiatives = initiativeRepository.findById(initiativeId)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id", initiativeId));
        Services service = servicesRepository.findById(idService).
        orElseThrow(() -> new ResourceNotFoundException("Este atractivo no se encuentra registrada con ", "id", idService));


        if(!service.getInitiative().getId().equals(initiatives.getId()) ){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"el atractivo no pertenece a la iniciativa");
        }
        service.setServicesName(serviceDTO.getServicesName());
        service.setDescription(serviceDTO.getDescription());
        service.setPricePerson(serviceDTO.getPricePerson());
        Services servicesUpdate = servicesRepository.save(service);
        return mapearDTO(servicesUpdate);
    }

    @Override
    public void deleteService(Long initiativeId, Long serviceId) {
        Initiative initiatives = initiativeRepository.findById(initiativeId)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id", initiativeId));
        Services service = servicesRepository.findById(serviceId).
        orElseThrow(() -> new ResourceNotFoundException("Este atractivo no se encuentra registrada con ", "id", serviceId));


        if(!service.getInitiative().getId().equals(initiatives.getId()) ){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"el atractivo no pertenece a la iniciativa");
        }
        servicesRepository.delete(service);
    }
    private ServicesDTO mapearDTO(Services services){
        return modelMapper.map(services,ServicesDTO.class);
    }
    private Services mapearEntity(ServicesDTO servicesDTO){
        return modelMapper.map(servicesDTO,Services.class);
    }
}
