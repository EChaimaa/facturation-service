package com.irisi.facturationservice.domain.paiement.delete;

import com.irisi.facturationservice.domain.core.AbstractProcessImpl;
import com.irisi.facturationservice.domain.core.Result;
import com.irisi.facturationservice.domain.pojo.PaiementPojo;
import com.irisi.facturationservice.infra.facade.PaiementInfra;

public class PaiementDeleteProcessImpl extends AbstractProcessImpl<PaiementDeleteInput> implements PaiementDeleteProcess {
    PaiementInfra paiementInfra;

    public PaiementDeleteProcessImpl(PaiementInfra paiementInfra) {
        this.paiementInfra = paiementInfra;
    }

    @Override
    public void validate(PaiementDeleteInput paiementDeleteInput, Result result) {
        String reference = paiementDeleteInput.getReference();
        PaiementPojo paiementPojo = paiementInfra.findByReference(reference);
        if (paiementPojo == null || paiementPojo.getId() == null) {
            result.addErrorMessage(paiementInfra.getMessage("paiement.delete.not_found"));
        }
    }

    @Override
    public void run(PaiementDeleteInput paiementDeleteInput, Result result) {
        String reference = paiementDeleteInput.getReference();
        paiementInfra.deleteByReference(reference);
        result.addInfoMessage(paiementInfra.getMessage("paiement.delete.deleted_success"));
        result.setStatus(1);
    }
}
