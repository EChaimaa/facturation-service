package com.irisi.facturationservice.domain.pojo;

import java.util.Date;
import java.util.List;

public class ProjetPojo {
    private Long id;
    private String reference;
    private String name;
    private Date beginTime;
    private Date endTime;
    private ClientPojo client;
    private List<ProjetMemberPojo> projetMembers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public ClientPojo getClient() {
        return client;
    }

    public void setClient(ClientPojo client) {
        this.client = client;
    }

    public List<ProjetMemberPojo> getProjetMembers() {
        return projetMembers;
    }

    public void setProjetMembers(List<ProjetMemberPojo> projetMembers) {
        this.projetMembers = projetMembers;
    }

    @Override
    public String toString() {
        return "ProjetPojo{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", client=" + client +
                ", projetMembers=" + projetMembers +
                '}';
    }
}
