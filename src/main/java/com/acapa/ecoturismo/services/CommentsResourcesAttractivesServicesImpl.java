package com.acapa.ecoturismo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.acapa.ecoturismo.dtos.CommentsResourcesAttractivesDTO;
import com.acapa.ecoturismo.entitys.CommentsResourcesAttractives;
import com.acapa.ecoturismo.entitys.ResourcesAttractives;
import com.acapa.ecoturismo.exceptions.BlogAppException;
import com.acapa.ecoturismo.exceptions.ResourceNotFoundException;
import com.acapa.ecoturismo.repository.CommentsResourcesAttractivesRepository;
import com.acapa.ecoturismo.repository.ResourcesAttractivesRepository;

@Service
public class CommentsResourcesAttractivesServicesImpl implements CommentsResourcesAttractivesServices {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CommentsResourcesAttractivesRepository commentsResourcesAttractivesRepository;
    @Autowired
    private ResourcesAttractivesRepository resourcesAttractivesRepository;

    @Override
    public CommentsResourcesAttractivesDTO createCommentsResourceAttractives(Long resourceAttractivesId,
            CommentsResourcesAttractivesDTO commentsResourcesAttractivesDTO) {
        CommentsResourcesAttractives commentsResourcesAttractives = mapearEntity(commentsResourcesAttractivesDTO);

        ResourcesAttractives resourcesAttractives = resourcesAttractivesRepository.findById(resourceAttractivesId)
                .orElseThrow(() -> new ResourceNotFoundException("Esta  Services no existe con ", "id",
                        resourceAttractivesId));

        commentsResourcesAttractives.setResourcesAttractives(resourcesAttractives);
        CommentsResourcesAttractives newCommentsResourcesAttractives = commentsResourcesAttractivesRepository
                .save(commentsResourcesAttractives);
        return mapearDTO(newCommentsResourcesAttractives);
    }

    @Override
    public List<CommentsResourcesAttractivesDTO> getCommentsResourcesAttractiveForResourceAttractiveId(
            long resourceAttractivesId) {
        List<CommentsResourcesAttractives> commentsResourcesAttractives = commentsResourcesAttractivesRepository
                .findByResourcesAttractivesId(resourceAttractivesId);
        return commentsResourcesAttractives.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public CommentsResourcesAttractivesDTO getCommentsResourceAttractiveId(Long resourceAttractivesId,
            Long idCommentsRA) {
        ResourcesAttractives resourcesAttractives = resourcesAttractivesRepository.findById(resourceAttractivesId)
                .orElseThrow(() -> new ResourceNotFoundException(" Este Services", "id", resourceAttractivesId));
        CommentsResourcesAttractives commentsResourcesAttractives = commentsResourcesAttractivesRepository
                .findById(idCommentsRA).orElseThrow(() -> new ResourceNotFoundException(
                        "Este recurso de servicio no se encuentra registrada con ", "id", idCommentsRA));

        if (!commentsResourcesAttractives.getResourcesAttractives().getId().equals(resourcesAttractives.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La CommentsResourcesAttractives no pertenece al recurso");
        }
        return mapearDTO(commentsResourcesAttractives);
    }

    @Override
    public CommentsResourcesAttractivesDTO updateCommentsResourceAttractives(Long resourceAttractiveId,
            Long idCommentsRA, CommentsResourcesAttractivesDTO commentsResourcesAttractivesDTO) {
        ResourcesAttractives resourcesAttractives = resourcesAttractivesRepository.findById(resourceAttractiveId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Services", "id", resourceAttractiveId));
        CommentsResourcesAttractives commentsResourcesAttractives = commentsResourcesAttractivesRepository
                .findById(idCommentsRA).orElseThrow(() -> new ResourceNotFoundException(
                        "Esta CommentsResourcesAttractives no se encuentra registrada con ", "id", idCommentsRA));

        if (!commentsResourcesAttractives.getResourcesAttractives().getId().equals(resourcesAttractives.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "La CommentsResourcesAttractives no pertenece a la organización");
        }

        commentsResourcesAttractives.setName(commentsResourcesAttractivesDTO.getName());
        commentsResourcesAttractives.setBody(commentsResourcesAttractivesDTO.getBody());
        commentsResourcesAttractives.setEmail(commentsResourcesAttractivesDTO.getEmail());
        // commentsResourcesAttractives.setTimeStamp(commentsResourcesAttractivesDTO.getTimeStamp());
        commentsResourcesAttractives.setUrlImgSession(commentsResourcesAttractivesDTO.getUrlImgSession());

        CommentsResourcesAttractives commentsResourcesAttractivesUpdate = commentsResourcesAttractivesRepository
                .save(commentsResourcesAttractives);
        return mapearDTO(commentsResourcesAttractivesUpdate);
    }

    @Override
    public void deleteCommentsResourceAttractives(Long resourceAttractivesId, Long idCommentsRA) {
        ResourcesAttractives resourcesAttractives = resourcesAttractivesRepository.findById(resourceAttractivesId)
                .orElseThrow(() -> new ResourceNotFoundException(" it's Services", "id", resourceAttractivesId));
        CommentsResourcesAttractives commentsResourcesAttractives = commentsResourcesAttractivesRepository
                .findById(idCommentsRA).orElseThrow(() -> new ResourceNotFoundException(
                        "Esta CommentsResourcesAttractives no se encuentra registrada con ", "id", idCommentsRA));

        if (!commentsResourcesAttractives.getResourcesAttractives().getId().equals(resourcesAttractives.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,
                    "El CommentsResourcesAttractives no pertenece al  Attractive");
        }
        commentsResourcesAttractivesRepository.delete(commentsResourcesAttractives);
    }

    private CommentsResourcesAttractivesDTO mapearDTO(CommentsResourcesAttractives commentsResourcesAttractives) {
        return modelMapper.map(commentsResourcesAttractives, CommentsResourcesAttractivesDTO.class);
    }

    private CommentsResourcesAttractives mapearEntity(CommentsResourcesAttractivesDTO commentsResourcesAttractivesDTO) {
        return modelMapper.map(commentsResourcesAttractivesDTO, CommentsResourcesAttractives.class);
    }
}
