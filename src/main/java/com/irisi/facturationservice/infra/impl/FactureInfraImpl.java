package com.irisi.facturationservice.infra.impl;

import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.infra.core.AbstractInfraImpl;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import com.irisi.facturationservice.infra.dao.FactureDao;
import com.irisi.facturationservice.infra.entity.FactureEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FactureInfraImpl extends AbstractInfraImpl implements FactureInfra {
    @Autowired
    FactureDao facDao;

    @Override
    public FacturePojo findByReference(String reference) {
        FactureEntity factureEntity = facDao.findByReference(reference);
        if (factureEntity == null) {
            return null;
        }
        FacturePojo facturePojo = new FacturePojo();
        BeanUtils.copyProperties(factureEntity, facturePojo);
        return facturePojo;
    }

    @Override
    public int deleteByReference(String reference) {
        return facDao.deleteByReference(reference);
    }

    @Override
    public FactureEntity save(FactureEntity factureEntity) {
        if (findByReference(factureEntity.getReference()) != null)
            return null;
        return facDao.save(factureEntity);
    }

    @Override
    public FactureEntity save(FacturePojo facturePojo) {
        FactureEntity factureEntity = new FactureEntity();
        BeanUtils.copyProperties(facturePojo, factureEntity);
        return save(factureEntity);
    }


    @Override
    public FactureEntity update(FactureEntity factureEntity) {
        if (findByReference(factureEntity.getReference()) == null)
            return null;
        return facDao.save(factureEntity);
    }

    @Override
    public FactureEntity update(FacturePojo facturePojo) {
        FactureEntity factureEntity = new FactureEntity();
        BeanUtils.copyProperties(facturePojo, factureEntity);
        return update(factureEntity);
    }

    @Override
    public List<FactureEntity> findAll() {
        return facDao.findAll();
    }
}
