package com.acapa.ecoturismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acapa.ecoturismo.entitys.ResourcesServices;

public interface ResourcesServicesRepository extends JpaRepository <ResourcesServices,Long> {
    public List<ResourcesServices> findByServicesId(long servicesId);    
}
