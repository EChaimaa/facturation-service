package com.irisi.facturationservice.domain.facture.create;

import com.irisi.facturationservice.domain.core.AbstractProcessInput;
import com.irisi.facturationservice.domain.pojo.FacturePojo;

public class FactureCreateInput extends AbstractProcessInput {
    private FacturePojo facture;

    public FacturePojo getFacture() {
        return facture;
    }

    public void setFacture(FacturePojo facture) {
        this.facture = facture;
    }
}
