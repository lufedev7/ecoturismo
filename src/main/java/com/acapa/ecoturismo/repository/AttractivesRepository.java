package com.acapa.ecoturismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acapa.ecoturismo.entitys.Attractives;

public interface AttractivesRepository extends JpaRepository <Attractives,Long> {
    public List<Attractives> findByInitiativeId(Long initiativeId);
}
