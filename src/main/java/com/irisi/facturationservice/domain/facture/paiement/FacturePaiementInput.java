package com.irisi.facturationservice.domain.facture.paiement;

import com.irisi.facturationservice.domain.core.AbstractProcessInput;

public class FacturePaiementInput extends AbstractProcessInput {
    String reference;
    double montant;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
