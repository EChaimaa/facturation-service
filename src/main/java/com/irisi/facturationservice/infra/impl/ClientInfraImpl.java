package com.irisi.facturationservice.infra.impl;

import com.irisi.facturationservice.domain.pojo.ClientPojo;
import com.irisi.facturationservice.infra.core.AbstractInfraImpl;
import com.irisi.facturationservice.infra.facade.ClientInfra;

public class ClientInfraImpl extends AbstractInfraImpl implements ClientInfra {
    @Override
    public ClientPojo findByReference(String reference) {
        ClientPojo client = new ClientPojo("Ezaghab","Chaimaa",
                "ezaghabchaimaa@gmail.com","0000000000","fstg");
        return client;
    }
}
