package com.irisi.facturationservice.domain.paiement.create;

import com.irisi.facturationservice.domain.core.AbstractProcessInput;
import com.irisi.facturationservice.domain.pojo.PaiementPojo;

public class PaiementCreateInput extends AbstractProcessInput {
    private String referenceFacture;
    private PaiementPojo paiement;

    public String getReferenceFacture() {
        return referenceFacture;
    }

    public void setReferenceFacture(String referenceFacture) {
        this.referenceFacture = referenceFacture;
    }

    public PaiementPojo getPaiement() {
        if (paiement == null) {
            paiement = new PaiementPojo();
        }
        return paiement;
    }

    public void setPaiement(PaiementPojo paiement) {
        this.paiement = paiement;
    }
}
