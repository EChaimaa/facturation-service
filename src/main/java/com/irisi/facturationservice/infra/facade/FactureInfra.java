package com.irisi.facturationservice.infra.facade;

import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.infra.core.AbstractInfra;
import com.irisi.facturationservice.infra.entity.FactureEntity;

import java.util.List;

public interface FactureInfra extends AbstractInfra {
    FacturePojo findByReference(String reference);

    int deleteByReference(String reference);

    public int save(FactureEntity facture);

    public int update(FactureEntity factureEntity);

    public int update(FacturePojo facturePojo);

    public List<FactureEntity> findAll();
}
