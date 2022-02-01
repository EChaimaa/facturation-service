package com.irisi.facturationservice.domain.pojo;

import java.util.Date;

public class ProjetDetailPojo {
    private Long id;
    private Date beginTime;
    private Date endTime;
    private ProjetMemberPojo projetMember;

    public ProjetDetailPojo() {
    }

    public ProjetDetailPojo(Date beginTime, Date endTime, ProjetMemberPojo projetMember) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.projetMember = projetMember;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProjetMemberPojo getProjetMember() {
        return projetMember;
    }

    public void setProjetMember(ProjetMemberPojo projetMember) {
        this.projetMember = projetMember;
    }

    @Override
    public String toString() {
        return "ProjetDetailPojo{" +
                "id=" + id +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", projetMember=" + projetMember +
                '}';
    }
}
