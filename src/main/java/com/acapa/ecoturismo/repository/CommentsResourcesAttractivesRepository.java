package com.acapa.ecoturismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acapa.ecoturismo.entitys.CommentsResourcesAttractives;

public interface CommentsResourcesAttractivesRepository extends JpaRepository<CommentsResourcesAttractives,Long>{
    public List<CommentsResourcesAttractives> findByResourcesAttractivesId(long resourcesAttractivesId);
}
