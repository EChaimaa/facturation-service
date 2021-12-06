package com.irisi.facturationservice.domain.paiement.delete;

import com.irisi.facturationservice.domain.core.AbstractProcessInput;

public class PaiementDeleteInput extends AbstractProcessInput {

    String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
