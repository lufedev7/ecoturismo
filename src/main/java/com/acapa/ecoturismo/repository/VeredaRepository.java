package com.acapa.ecoturismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acapa.ecoturismo.entitys.Vereda;

public interface VeredaRepository extends JpaRepository<Vereda, Long>{
    public List<Vereda> findByOrganizationsId(long organizationId);
}
