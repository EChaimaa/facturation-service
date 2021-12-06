package com.irisi.facturationservice.infra.impl;

import com.irisi.facturationservice.domain.pojo.PaiementPojo;
import com.irisi.facturationservice.infra.core.AbstractInfraImpl;
import com.irisi.facturationservice.infra.facade.PaiementInfra;
import com.irisi.facturationservice.infra.dao.PaiementDao;
import com.irisi.facturationservice.infra.entity.PaiementEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaiementInfraImpl extends AbstractInfraImpl implements PaiementInfra {
    @Autowired
    PaiementDao paiementDao;

    @Override
    public PaiementPojo findByReference(String reference) {
        return null;
    }

    @Override
    public int deleteByReference(String reference) {
        return 0;
    }

    @Override
    public int save(PaiementEntity paiement) {
        paiementDao.save(paiement);
        return 1;
    }

    @Override
    public int update(PaiementEntity paiementEntity) {
        if (findByReference(paiementEntity.getReference()) == null)
            return -1;
        paiementDao.save(paiementEntity);
        return 1;
    }

    @Override
    public int update(PaiementPojo paiementPojo) {
        PaiementEntity paiementEntity = new PaiementEntity();
        BeanUtils.copyProperties(paiementPojo,paiementEntity);
        return update(paiementEntity);
    }

    @Override
    public List<PaiementEntity> findAll() {
        return paiementDao.findAll();
    }
}
