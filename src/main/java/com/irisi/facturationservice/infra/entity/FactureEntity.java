package com.irisi.facturationservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class FactureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFacture;
    private String status;  //payed | notPayed
    private String clientRef;
    private String projectRef;
    private double total;
    @Lob
    private byte[] pdf;

}



