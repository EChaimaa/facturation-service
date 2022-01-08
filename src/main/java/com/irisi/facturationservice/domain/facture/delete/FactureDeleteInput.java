package com.irisi.facturationservice.domain.facture.delete;

import com.irisi.facturationservice.domain.core.AbstractProcessInput;

public class FactureDeleteInput extends AbstractProcessInput {

    String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
