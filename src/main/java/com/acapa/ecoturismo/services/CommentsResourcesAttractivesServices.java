package com.acapa.ecoturismo.services;

import java.util.List;

import com.acapa.ecoturismo.dtos.CommentsResourcesAttractivesDTO;

public interface CommentsResourcesAttractivesServices {
    public CommentsResourcesAttractivesDTO createCommentsResourceAttractives(Long resourceAttractivesId, CommentsResourcesAttractivesDTO commentsResourcesAttractivesDTO);
    public List<CommentsResourcesAttractivesDTO> getCommentsResourcesAttractiveForResourceAttractiveId(long resourceAttractivesId);
    public CommentsResourcesAttractivesDTO getCommentsResourceAttractiveId(Long resourceAttractivesId, Long idCommentsRA);
    public CommentsResourcesAttractivesDTO updateCommentsResourceAttractives(Long resourceAttractiveId, Long idCommentsRA, CommentsResourcesAttractivesDTO commentsResourcesAttractivesDTO);
    public void deleteCommentsResourceAttractives(Long resourceAttractivesId, Long idCommentsRA);
}
