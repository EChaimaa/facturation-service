package com.irisi.facturationservice.infra.impl;

import com.irisi.facturationservice.domain.pojo.PaiementPojo;
import com.irisi.facturationservice.infra.core.AbstractInfraImpl;
import com.irisi.facturationservice.infra.facade.PaiementInfra;
import com.irisi.facturationservice.infra.dao.PaiementDao;
import com.irisi.facturationservice.infra.entity.PaiementEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementInfraImpl extends AbstractInfraImpl implements PaiementInfra {
    @Autowired
    PaiementDao paiementDao;

    @Override
    public PaiementPojo findByReference(String reference) {
        PaiementEntity paiementEntity = paiementDao.findByReference(reference);
        if(paiementEntity == null){
            return null;
        }
        PaiementPojo paiementPojo = new PaiementPojo();
        BeanUtils.copyProperties(paiementEntity, paiementPojo);
        return paiementPojo;
    }

    @Override
    public int deleteByReference(String reference) {
        return paiementDao.deleteByReference(reference);
    }

    @Override
    public PaiementEntity save(PaiementEntity paiementEntity) {
        if(findByReference(paiementEntity.getReference()) != null){
            return null;
        }
        return paiementDao.save(paiementEntity);
    }

    @Override
    public PaiementEntity save(PaiementPojo paiementPojo) {
        PaiementEntity paiementEntity = new PaiementEntity();
        BeanUtils.copyProperties(paiementPojo, paiementEntity);
        return save(paiementEntity);
    }

    @Override
    public PaiementEntity update(PaiementEntity paiementEntity) {
        if(findByReference(paiementEntity.getReference()) == null){
            return null;
        }
        return paiementDao.save(paiementEntity);
    }

    @Override
    public PaiementEntity update(PaiementPojo paiementPojo) {
        PaiementEntity paiementEntity = new PaiementEntity();
        BeanUtils.copyProperties(paiementPojo, paiementEntity);
        return update(paiementEntity);
    }

    @Override
    public List<PaiementEntity> findAll() {
        return paiementDao.findAll();
    }
}
