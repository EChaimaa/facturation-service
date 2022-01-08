package com.irisi.facturationservice.infra.facade;

import com.irisi.facturationservice.domain.pojo.PaiementPojo;
import com.irisi.facturationservice.infra.core.AbstractInfra;
import com.irisi.facturationservice.infra.entity.PaiementEntity;

import java.util.List;

public interface PaiementInfra extends AbstractInfra {

    PaiementPojo findByReference(String reference);

    int deleteByReference(String reference);

    public PaiementEntity save(PaiementEntity paiement);

    public PaiementEntity save(PaiementPojo paiementPojo);

    public PaiementEntity update(PaiementEntity paiementEntity);

    public PaiementEntity update(PaiementPojo paiementPojo);

    public List<PaiementEntity> findAll();
}
