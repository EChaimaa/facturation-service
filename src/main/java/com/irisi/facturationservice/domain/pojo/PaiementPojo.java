package com.irisi.facturationservice.domain.pojo;

import com.irisi.facturationservice.infra.entity.FactureEntity;

import java.math.BigDecimal;

public class PaiementPojo {
    private Long id;
    private FacturePojo facture;
    private String reference;
    private double montant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FacturePojo getFacture() {
        return facture;
    }

    public void setFacture(FacturePojo facture) {
        this.facture = facture;
    }

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
