package com.acapa.ecoturismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acapa.ecoturismo.entitys.Services;

public interface ServicesRepository extends JpaRepository<Services, Long> {
     public List<Services> findBypruebaId(Long initiativeId);
}
