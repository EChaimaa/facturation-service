package com.irisi.facturationservice.infra.facade;

import com.irisi.facturationservice.domain.pojo.ProjetPojo;
import com.irisi.facturationservice.infra.core.AbstractInfra;

public interface ProjetInfra extends AbstractInfra {
    ProjetPojo findByReference(String reference);
}
