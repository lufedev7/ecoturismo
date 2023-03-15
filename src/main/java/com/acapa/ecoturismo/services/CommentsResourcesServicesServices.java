package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.CommentsResourceServicesDTO;

public interface CommentsResourcesServicesServices {
    public CommentsResourceServicesDTO createCommentsResourceService(Long resourceServicesId, CommentsResourceServicesDTO commentsResourceServicesDTO);
    public List<CommentsResourceServicesDTO> getCommentsResourcesServiceForResourceServiceId(long resourceServicesId);
    public CommentsResourceServicesDTO getCommentsResourceServiceId(Long resourceServicesId, Long idCommentsRS);
    public CommentsResourceServicesDTO updateCommentsResourceService(Long resourceServicesId, Long idCommentsRS, CommentsResourceServicesDTO commentsResourceServicesDTO);
    public void deleteCommentsResourceService(Long resourceServicesId, Long idCommentsRS);
}
