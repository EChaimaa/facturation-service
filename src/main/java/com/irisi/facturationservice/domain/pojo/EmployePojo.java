package com.irisi.facturationservice.domain.pojo;

import java.util.List;

public class EmployePojo {
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private CategoriePojo categorie;
    private List<ProjetMemberPojo> projetMembers;

    public List<ProjetMemberPojo> getProjetMembers() {
        return projetMembers;
    }

    public void setProjetMembers(List<ProjetMemberPojo> projetMembers) {
        this.projetMembers = projetMembers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public CategoriePojo getCategorie() {
        return categorie;
    }

    public void setCategorie(CategoriePojo categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "EmployePojo{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", categorie=" + categorie +
                '}';
    }
}
