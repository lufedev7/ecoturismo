package com.acapa.ecoturismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acapa.ecoturismo.entitys.CommentsResourcesServices;

public interface CommentsResourcesServicesRepository extends JpaRepository<CommentsResourcesServices,Long>{
    public List<CommentsResourcesServices> findByResourcesServicesId(long resourcesServicesId);
}
