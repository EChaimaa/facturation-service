package com.irisi.facturationservice.infra.impl;

import com.irisi.facturationservice.domain.pojo.ProjetPojo;
import com.irisi.facturationservice.infra.core.AbstractInfraImpl;
import com.irisi.facturationservice.infra.facade.ProjetInfra;
import com.irisi.facturationservice.infra.proxy.ProjetProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetInfraImpl extends AbstractInfraImpl implements ProjetInfra {
    @Autowired
    private ProjetProxy projetProxy;

    @Override
    public ProjetPojo findByReference(String reference) {
        return projetProxy.findByReference(reference);
    }
}
