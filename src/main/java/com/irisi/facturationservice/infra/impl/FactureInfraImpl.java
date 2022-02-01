package com.irisi.facturationservice.infra.impl;

import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.domain.pojo.ProjetMemberPojo;
import com.irisi.facturationservice.domain.pojo.ProjetPojo;
import com.irisi.facturationservice.infra.converter.FactureConverter;
import com.irisi.facturationservice.infra.core.AbstractInfraImpl;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import com.irisi.facturationservice.infra.dao.FactureDao;
import com.irisi.facturationservice.infra.entity.FactureEntity;
import com.irisi.facturationservice.infra.proxy.ProjetProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureInfraImpl extends AbstractInfraImpl implements FactureInfra {
    @Autowired
    FactureDao facDao;
    @Autowired
    ProjetProxy projetProxy;

    @Override
    public FacturePojo findByReference(String reference) {
        FactureEntity factureEntity = facDao.findByReference(reference);
        if (factureEntity == null) {
            return null;
        }
        FactureConverter factureConverter = new FactureConverter();
        FacturePojo facturePojo = factureConverter.toPojo(factureEntity);
        return facturePojo;
    }

    @Override
    public int deleteByReference(String reference) {
        return facDao.deleteByReference(reference);
    }

    @Override
    public FactureEntity save(FactureEntity factureEntity) {
        if (findByReference(factureEntity.getReference()) != null) return null;
        return facDao.save(factureEntity);
    }

    @Override
    public FacturePojo save(FacturePojo facturePojo) {
        FactureConverter factureConverter = new FactureConverter();
        FactureEntity factureEntity = factureConverter.toEntity(facturePojo);
        FacturePojo facture = factureConverter.toPojo(save(factureEntity));
        return facture;
    }


    @Override
    public FactureEntity update(FactureEntity factureEntity) {
        if (findByReference(factureEntity.getReference()) == null)
            return null;
        return facDao.save(factureEntity);
    }

    @Override
    public FacturePojo update(FacturePojo facturePojo) {
        FactureConverter factureConverter = new FactureConverter();
        FactureEntity factureEntity = factureConverter.toEntity(facturePojo);
        FacturePojo facture = factureConverter.toPojo(update(factureEntity));
        return facture;
    }

    @Override
    public List<FactureEntity> findAll() {
        return facDao.findAll();
    }

    @Override
    public List<ProjetMemberPojo> findProjetMembers(FacturePojo facturePojo) {
        ProjetPojo projetPojo = projetProxy.findByReference(facturePojo.getProjectRef());
        List<ProjetMemberPojo> projetMembers = projetProxy.findProjetMembersByProject(projetPojo.getReference());
        return  projetMembers;
    }

    @Override
    public double calculTotalFacture(FacturePojo facturePojo) {
        ProjetPojo projetPojo = projetProxy.findByReference(facturePojo.getProjectRef());
        List<ProjetMemberPojo> projetMembers = projetProxy.findProjetMembersByProject(projetPojo.getReference());
        double total = 0;
        for (ProjetMemberPojo projetMember: projetMembers) {
            total += projetMember.getEmploye().getCategorie().getSalaireParHeure() * projetMember.getNbrHeures();
        }
        return total;
    }
}
