package com.acapa.ecoturismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acapa.ecoturismo.entitys.ResourcesAttractives;

public interface ResourcesAttractivesRepository extends JpaRepository<ResourcesAttractives,Long>{
    public List<ResourcesAttractives> findByAttractiveId(long attractivesId);
}
