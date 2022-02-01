package com.irisi.facturationservice.domain.facture.delete;

import com.irisi.facturationservice.domain.core.AbstractProcessImpl;
import com.irisi.facturationservice.domain.core.AbstractProcessInput;
import com.irisi.facturationservice.domain.core.Result;
import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.infra.facade.FactureInfra;

public class FactureDeleteProcessImpl extends AbstractProcessImpl<FactureDeleteInput> implements FactureDeleteProcess {
    FactureInfra factureInfra;

    public FactureDeleteProcessImpl(FactureInfra factureInfra) {
        this.factureInfra = factureInfra;
    }

    @Override
    public void validate(FactureDeleteInput factureDeleteInput, Result result) {
        String reference = factureDeleteInput.getReference();
        FacturePojo facturePojo = factureInfra.findByReference(reference);
        if (facturePojo == null || facturePojo.getId() == null) {
            result.addErrorMessage(factureInfra.getMessage("facture.delete.not_found"));
        }
        if (facturePojo.getStatus().equalsIgnoreCase("payee")) {
                result.addErrorMessage(factureInfra.getMessage("facture.delete.prob_itsPayed"));
        }
    }

    @Override
    public void run(FactureDeleteInput factureDeleteInput, Result result) {
        String reference = factureDeleteInput.getReference();
        factureInfra.deleteByReference(reference);
        result.addInfoMessage(factureInfra.getMessage("facture.delete.deleted_success"));
        result.setStatus(1);
    }
}
