package com.irisi.facturationservice.infra.facade;

import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.domain.pojo.ProjetMemberPojo;
import com.irisi.facturationservice.infra.core.AbstractInfra;
import com.irisi.facturationservice.infra.entity.FactureEntity;

import java.util.List;

public interface FactureInfra extends AbstractInfra {
    FacturePojo findByReference(String reference);

    int deleteByReference(String reference);

    FactureEntity save(FactureEntity facture);

    FacturePojo save(FacturePojo facturePojo);

    FactureEntity update(FactureEntity factureEntity);

    FacturePojo update(FacturePojo facturePojo);

    List<FactureEntity> findAll();

    List<ProjetMemberPojo> findProjetMembers(FacturePojo facturePojo);

    double calculTotalFacture(FacturePojo facturePojo);
}
