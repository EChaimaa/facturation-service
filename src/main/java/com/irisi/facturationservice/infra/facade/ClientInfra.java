package com.irisi.facturationservice.infra.facade;

import com.irisi.facturationservice.domain.pojo.ClientPojo;
import com.irisi.facturationservice.infra.core.AbstractInfra;

public interface ClientInfra extends AbstractInfra {
    ClientPojo findByReference(String reference);
}
