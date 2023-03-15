package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.CommentsResourceServicesDTO;
import com.acapa.ecoturismo.entitys.CommentsResourcesServices;
import com.acapa.ecoturismo.entitys.ResourcesServices;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.CommentsResourcesServicesRepository;
import com.acapa.ecoturismo.repository.ResourcesServicesRepository;
@Service
public class CommentsResourcesServicesServicesImpl implements CommentsResourcesServicesServices{
    @Autowired
    private CommentsResourcesServicesRepository commentsResourcesServicesRepository;
    @Autowired
    private ResourcesServicesRepository resourcesServicesRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentsResourceServicesDTO createCommentsResourceService(Long resourceServicesId,
            CommentsResourceServicesDTO commentsResourceServicesDTO) {
                CommentsResourcesServices commentsResourcesServices = mapearEntity(commentsResourceServicesDTO);

        ResourcesServices resourcesServices = resourcesServicesRepository.findById(resourceServicesId)
        .orElseThrow(() -> new ResourceNotFoundException("Esta  Services no existe con ", "id", resourceServicesId));



        commentsResourcesServices.setResourcesServices(resourcesServices);
        CommentsResourcesServices newCommentsResourcesServices = commentsResourcesServicesRepository.save(commentsResourcesServices);
        return mapearDTO(newCommentsResourcesServices);
    }

    @Override
    public List<CommentsResourceServicesDTO> getCommentsResourcesServiceForResourceServiceId(long resourceServicesId) {
        List<CommentsResourcesServices> commentsResourcesServices = commentsResourcesServicesRepository.findByResourcesServicesId(resourceServicesId);
        return  commentsResourcesServices.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public CommentsResourceServicesDTO getCommentsResourceServiceId(Long resourceServicesId, Long idCommentsRS) {
        ResourcesServices resourcesServices = resourcesServicesRepository.findById(resourceServicesId)
        .orElseThrow(() -> new ResourceNotFoundException(" Este Services", "id", resourceServicesId));
        CommentsResourcesServices commentsResourcesServices = commentsResourcesServicesRepository.findById(idCommentsRS).
        orElseThrow(() -> new ResourceNotFoundException("Este recurso de servicio no se encuentra registrada con ", "id", idCommentsRS));


        if(!commentsResourcesServices.getResourcesServices().getId().equals(resourcesServices.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"La CommentsResourcesServices no pertenece al recurso");
        }
        return mapearDTO(commentsResourcesServices);
    }

    @Override
    public CommentsResourceServicesDTO updateCommentsResourceService(Long resourceServicesId, Long idCommentsRS,
            CommentsResourceServicesDTO commentsResourceServicesDTO) {
                ResourcesServices resourcesServices = resourcesServicesRepository.findById(resourceServicesId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Services", "id", resourceServicesId));
                CommentsResourcesServices commentsResourcesServices = commentsResourcesServicesRepository.findById(idCommentsRS).
                orElseThrow(() -> new ResourceNotFoundException("Esta CommentsResourcesServices no se encuentra registrada con ", "id", idCommentsRS));


                if(!commentsResourcesServices.getResourcesServices().getId().equals(resourcesServices.getId())){
                    throw new BlogAppException(HttpStatus.BAD_REQUEST,"La CommentsResourcesServices no pertenece a la organización");
                }

                commentsResourcesServices.setName(commentsResourceServicesDTO.getName());
                commentsResourcesServices.setBody(commentsResourceServicesDTO.getBody());
                commentsResourcesServices.setEmail(commentsResourceServicesDTO.getEmail());
                commentsResourcesServices.setTimeStamp(commentsResourceServicesDTO.getTimeStamp());
                commentsResourcesServices.setUrlImgSession(commentsResourceServicesDTO.getUrlImgSession());


                CommentsResourcesServices commentsResourcesServicesUpdate = commentsResourcesServicesRepository.save(commentsResourcesServices);
                return mapearDTO(commentsResourcesServicesUpdate);
    }

    @Override
    public void deleteCommentsResourceService(Long resourceServicesId, Long idCommentsRS) {
        ResourcesServices resourcesServices = resourcesServicesRepository.findById(resourceServicesId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Services", "id", resourceServicesId));
                CommentsResourcesServices commentsResourcesServices = commentsResourcesServicesRepository.findById(idCommentsRS).
                orElseThrow(() -> new ResourceNotFoundException("Esta CommentsResourcesServices no se encuentra registrada con ", "id", idCommentsRS));


                if(!commentsResourcesServices.getResourcesServices().getId().equals(resourcesServices.getId())){
                    throw new BlogAppException(HttpStatus.BAD_REQUEST,"El CommentsResourcesServices no pertenece al  servicio");
                }
                commentsResourcesServicesRepository.delete(commentsResourcesServices);
    }
    private CommentsResourceServicesDTO mapearDTO(CommentsResourcesServices commentsResourcesServices){
        return modelMapper.map(commentsResourcesServices,CommentsResourceServicesDTO.class);
    }
    private CommentsResourcesServices mapearEntity(CommentsResourceServicesDTO commentsResourceServicesDTO){
        return modelMapper.map(commentsResourceServicesDTO,CommentsResourcesServices.class);
    }
}
