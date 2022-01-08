package com.irisi.facturationservice.domain.facture.paiement;

import com.irisi.facturationservice.domain.core.AbstractProcessImpl;
import com.irisi.facturationservice.domain.core.AbstractProcessInput;
import com.irisi.facturationservice.domain.core.Result;
import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.infra.facade.FactureInfra;

public class FacturePaimentProcessImpl extends AbstractProcessImpl<FacturePaiementInput> implements FacturePaiementProcess {
    FactureInfra factureInfra;

    public FacturePaimentProcessImpl(FactureInfra factureInfra) {
        this.factureInfra = factureInfra;
    }

    @Override
    public void validate(FacturePaiementInput facturePaiementInput, Result result) {
        String reference = facturePaiementInput.getReference();
        double montant = facturePaiementInput.getMontant();
        FacturePojo facturePojo = factureInfra.findByReference(reference);
        if (facturePojo == null || facturePojo.getId() == null) {
            result.addErrorMessage(factureInfra.getMessage("facture.paiment.not_found"));
        } else if (montant != facturePojo.getTotal()) {
            result.addErrorMessage(factureInfra.getMessage("facture.paiment.prob_paiment"));
        }
    }

    @Override
    public void run(FacturePaiementInput facturePaiementInput, Result result) {
        String reference = facturePaiementInput.getReference();
        double montant = facturePaiementInput.getMontant();
        FacturePojo commande = factureInfra.findByReference(reference);
        commande.setStatus("Payée");
        factureInfra.update(commande);
        result.addInfoMessage(factureInfra.getMessage("facture.paiment.created_success"));
    }
}
