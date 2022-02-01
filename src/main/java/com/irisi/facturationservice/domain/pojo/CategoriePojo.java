package com.irisi.facturationservice.domain.pojo;

public class CategoriePojo {
    private Long id;
    private String libelle;
    private int salaireParHeure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getSalaireParHeure() {
        return salaireParHeure;
    }

    public void setSalaireParHeure(int salaireParHeure) {
        this.salaireParHeure = salaireParHeure;
    }

    @Override
    public String toString() {
        return "CategoriePojo{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", salaireParHeure=" + salaireParHeure +
                '}';
    }
}
