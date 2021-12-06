package com.irisi.facturationservice.infra.dao;

import com.irisi.facturationservice.infra.entity.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<FactureEntity, Long> {

    FactureEntity findByReference(String reference);

    int deleteByReference(String reference);
}
