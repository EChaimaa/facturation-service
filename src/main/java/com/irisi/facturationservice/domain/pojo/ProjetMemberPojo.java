package com.irisi.facturationservice.domain.pojo;

import java.util.List;

public class ProjetMemberPojo {
    private Long id;
    private EmployePojo employe;
    private ProjetPojo projet;
    private long nbrHeures;
    private List<ProjetDetailPojo> workDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployePojo getEmploye() {
        return employe;
    }

    public void setEmploye(EmployePojo employe) {
        this.employe = employe;
    }

    public ProjetPojo getProjet() {
        return projet;
    }

    public void setProjet(ProjetPojo projet) {
        this.projet = projet;
    }

    public long getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(long nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public List<ProjetDetailPojo> getWorkDetails() {
        return workDetails;
    }

    public void setWorkDetails(List<ProjetDetailPojo> workDetails) {
        this.workDetails = workDetails;
    }

    @Override
    public String toString() {
        return "ProjetMemberPojo{" +
                "id=" + id +
                ", employe=" + employe +
                ", projet=" + projet +
                ", nbrHeures=" + nbrHeures +
                ", workDetails=" + workDetails +
                '}';
    }
}
