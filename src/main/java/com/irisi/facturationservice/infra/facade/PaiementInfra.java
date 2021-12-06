package com.irisi.facturationservice.infra.facade;

import com.irisi.facturationservice.domain.pojo.PaiementPojo;
import com.irisi.facturationservice.infra.core.AbstractInfra;
import com.irisi.facturationservice.infra.entity.PaiementEntity;

import java.util.List;

public interface PaiementInfra extends AbstractInfra {

    PaiementPojo findByReference(String reference);

    int deleteByReference(String reference);

    public int save(PaiementEntity paiement);

    public int update(PaiementEntity paiementEntity);

    public int update(PaiementPojo paiementPojo);

    public List<PaiementEntity> findAll();
}
