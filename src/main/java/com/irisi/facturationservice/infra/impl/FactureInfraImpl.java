package com.irisi.facturationservice.infra.impl;

import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.infra.core.AbstractInfraImpl;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import com.irisi.facturationservice.infra.dao.FactureDao;
import com.irisi.facturationservice.infra.entity.FactureEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FactureInfraImpl extends AbstractInfraImpl implements FactureInfra {
    @Autowired
    FactureDao facDao;

    @Override
    public FacturePojo findByReference(String reference) {
        FactureEntity factureEntity = facDao.findByReference(reference);
        FacturePojo facturePojo= new FacturePojo();
        if(factureEntity!=null){
            BeanUtils.copyProperties(factureEntity,facturePojo);
        }
        return facturePojo;
    }

    @Override
    public int deleteByReference(String reference) {
        return facDao.deleteByReference(reference);
    }

    @Override
    public int save(FactureEntity facture) {
        if (findByReference(facture.getReference()) != null)
            return -1;
        facDao.save(facture);
        return 1;
    }

    @Override
    public int update(FactureEntity factureEntity) {
        if (findByReference(factureEntity.getReference()) == null)
            return -1;
        facDao.save(factureEntity);
        return 1;
    }

    @Override
    public int update(FacturePojo facturePojo) {
        FactureEntity factureEntity = new FactureEntity();
        BeanUtils.copyProperties(facturePojo,factureEntity);
        return update(factureEntity);
    }

    @Override
    public List<FactureEntity> findAll() {
        return facDao.findAll();
    }
}
