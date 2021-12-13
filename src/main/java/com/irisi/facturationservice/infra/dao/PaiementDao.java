package com.irisi.facturationservice.infra.dao;

import com.irisi.facturationservice.infra.entity.PaiementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<PaiementEntity, Long> {
    PaiementEntity findByReference(String reference);

    int deleteByReference(String reference);

    @Query("SELECT p FROM  PaiementEntity  p where  p.montant > :montant")
    List<PaiementEntity> findPaiementsSupThan(@Param("montant") double montant);
}
