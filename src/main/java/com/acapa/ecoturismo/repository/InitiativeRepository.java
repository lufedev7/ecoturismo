package com.acapa.ecoturismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acapa.ecoturismo.entitys.prueba;

import java.util.List;

public interface InitiativeRepository extends JpaRepository<prueba, Long> {

    public List<prueba> findByVeredaId(Long veredaId);

    public List<prueba> findByContactId(Long contactId);
}
