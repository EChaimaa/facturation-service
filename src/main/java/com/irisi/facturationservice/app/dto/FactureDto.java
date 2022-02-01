package com.irisi.facturationservice.app.dto;

import java.util.Date;

public class FactureDto {
    private Long id;
    private String reference;
    private String clientRef;
    private String projectRef;
    private Date dateFacture;
    private String status;   // payee|nonPayee
    private double total;
    private byte[] pdf;

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }

    public String getProjectRef() {
        return projectRef;
    }

    public void setProjectRef(String projectRef) {
        this.projectRef = projectRef;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
