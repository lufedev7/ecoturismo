package com.acapa.ecoturismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.acapa.ecoturismo.entitys.Initiative;

public interface InitiativeRepository extends JpaRepository<Initiative,Long>{
    public List<Initiative> findByVeredaId(Long veredaId);
}
