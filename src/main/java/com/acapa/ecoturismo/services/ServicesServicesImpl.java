package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.acapa.ecoturismo.dtos.ServicesDTO;
import com.acapa.ecoturismo.dtos.ServicesDTOUse;
import com.acapa.ecoturismo.dtos.TypeServicesDTO;
import com.acapa.ecoturismo.entitys.Services;
import com.acapa.ecoturismo.entitys.TypesServices;
import com.acapa.ecoturismo.entitys.prueba;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.InitiativeRepository;
import com.acapa.ecoturismo.repository.ServicesRepository;
//import com.acapa.ecoturismo.repository.ServicesRepository;
import com.acapa.ecoturismo.repository.TypesServicesRepository;

@Service
public class ServicesServicesImpl implements ServicesServices {

  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private ServicesRepository servicesRepository;

  @Autowired
  private TypesServicesRepository typesServicesRepository;

  @Autowired
  private InitiativeRepository initiativeRepository;

  @Override
  public ServicesDTOUse createServices(Long initiativeId, Long typeServiceId, ServicesDTOUse serviceDTO) {

    Services services = mapearEntity(serviceDTO);

    prueba inittiatives = initiativeRepository.findById(initiativeId)
        .orElseThrow(
            () -> new ResourceNotFoundException("Esta  Initiatives no existe con ", "id",
                initiativeId));

    TypesServices typeService = typesServicesRepository.findById(typeServiceId)
        .orElseThrow(() -> new ResourceNotFoundException("Este TypeAttractiveo no existe con ", "id",
            typeServiceId));

    System.out.println("este es el type de services" + typeService);
    services.setTypesservices(typeService);
    services.setPrueba(inittiatives);
    Services newServices = servicesRepository.save(services);
    return mapearDTOUse(newServices);
  }

  @Override
  public List<ServicesDTO> getserviceForInitiativeId(long initiativeId) {

    List<Services> services = servicesRepository.findBypruebaId(initiativeId);

    return services.stream().map(this::mapearDTO).collect(Collectors.toList());
  }

  @Override
  public ServicesDTO getServiceById(Long idInitiative, Long idservice) {

    prueba initiatives = initiativeRepository.findById(idInitiative)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id",
            idInitiative));

    Services service = servicesRepository.findById(idservice).orElseThrow(
        () -> new ResourceNotFoundException("Este Servicio no se encuentra registrada con ",
            "id", idservice));

    if (!service.getPrueba().getId().equals(initiatives.getId())) {
      throw new BlogAppException(HttpStatus.BAD_REQUEST,
          "el servicio no pertenece a la iniciativa");
    }

    return mapearDTO(service);
  }

  @Override
  public ServicesDTOUse updateService(Long initiativeId, Long idService, ServicesDTOUse serviceDTO) {

    prueba initiatives = initiativeRepository.findById(initiativeId)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id",
            initiativeId));

    Services service = servicesRepository.findById(idService).orElseThrow(
        () -> new ResourceNotFoundException("Este atractivo no se encuentra registrada con ",
            "id", idService));

    if (!service.getPrueba().getId().equals(initiatives.getId())) {
      throw new BlogAppException(HttpStatus.BAD_REQUEST,
          "el atractivo no pertenece a la iniciativa");
    }

    service.setServicesName(serviceDTO.getServicesName());
    service.setDescription(serviceDTO.getDescription());
    service.setPricePerson(serviceDTO.getPricePerson());
    Services servicesUpdate = servicesRepository.save(service);

    return mapearDTOUse(servicesUpdate);
  }

  @Override
  public void deleteService(Long initiativeId, Long serviceId) {

    prueba initiatives = initiativeRepository.findById(initiativeId)
        .orElseThrow(() -> new ResourceNotFoundException(" it's Initiatives", "id",
            initiativeId));

    Services service = servicesRepository.findById(serviceId).orElseThrow(
        () -> new ResourceNotFoundException("Este atractivo no se encuentra registrada con ",
            "id", serviceId));

    if (!service.getPrueba().getId().equals(initiatives.getId())) {
      throw new BlogAppException(HttpStatus.BAD_REQUEST,
          "el atractivo no pertenece a la iniciativa");
    }

    servicesRepository.delete(service);

  }

  private ServicesDTO mapearDTO(Services services) {
    return modelMapper.map(services, ServicesDTO.class);
  }

  private ServicesDTOUse mapearDTOUse(Services services) {
    return modelMapper.map(services, ServicesDTOUse.class);
  }

  private Services mapearEntity(ServicesDTOUse servicesDTO) {
    return modelMapper.map(servicesDTO, Services.class);
  }

  @Override
  public List<ServicesDTO> getAllservice() {
    List<Services> services = servicesRepository.findAll();
    return services.stream().map(cont -> mapearDTO(cont)).collect(Collectors.toList());
  }

}
