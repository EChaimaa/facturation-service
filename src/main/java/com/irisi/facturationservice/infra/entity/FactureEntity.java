package com.irisi.facturationservice.infra.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class FactureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFacture;
    private String status;  //payed | notPayed
    private String clientRef;
    private String projectRef;
    private double total;

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}



