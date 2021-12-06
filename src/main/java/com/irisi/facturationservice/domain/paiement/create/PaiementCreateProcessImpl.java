package com.irisi.facturationservice.domain.paiement.create;

import com.irisi.facturationservice.domain.core.AbstractProcessImpl;
import com.irisi.facturationservice.domain.core.Result;
import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.domain.pojo.PaiementPojo;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import com.irisi.facturationservice.infra.facade.PaiementInfra;

public class PaiementCreateProcessImpl extends AbstractProcessImpl<PaiementCreateInput> implements PaiementCreateProcess {
    FactureInfra factureInfra;
    PaiementInfra paiementInfra;

    public PaiementCreateProcessImpl(FactureInfra factureInfra, PaiementInfra paiementInfra) {
        this.factureInfra = factureInfra;
        this.paiementInfra = paiementInfra;
    }

    @Override
    public void validate(PaiementCreateInput abstractProcessInput, Result result) {
        FacturePojo facture = factureInfra.findByReference(abstractProcessInput.getReferenceFacture());
        PaiementPojo paiement = paiementInfra.findByReference(abstractProcessInput.getPaiement().getReference());
        if (facture == null) {
            result.addErrorMessage("paiement.create.facture_not_founded");
        }else if(abstractProcessInput.getPaiement().getMontant() != facture.getTotal()){
            result.addErrorMessage("paiement.create.montant_invalid");
        }
        if (paiement != null && paiement.getId() != null) {
            result.addErrorMessage("paiement.create.paiement_already_exists");
        }
    }

    @Override
    public void run(PaiementCreateInput abstractProcessInput, Result result) {

    }
}
