package com.irisi.facturationservice.infra.facade;

import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.infra.core.AbstractInfra;
import com.irisi.facturationservice.infra.entity.FactureEntity;

import java.util.List;

public interface FactureInfra extends AbstractInfra {
    FacturePojo findByReference(String reference);

    int deleteByReference(String reference);

    public FactureEntity save(FactureEntity facture);

    public FactureEntity save(FacturePojo facturePojo);

    public FactureEntity update(FactureEntity factureEntity);

    public FactureEntity update(FacturePojo facturePojo);

    public List<FactureEntity> findAll();
}
