package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto;

public class QuestionDTO {
    private int numero;
    private String langue;
    private String libelle;
    private String reponse;
    private DifficultéEnum difficulte;
    private int nbPoseTotal;
    private int nbRepCorrect;

    public QuestionDTO(int numero, String langue, String libelle, String reponse, DifficultéEnum difficulte, int nbPoseTotal, int nbRepCorrect) {
        this.numero = numero;
        this.langue = langue;
        this.libelle = libelle;
        this.reponse = reponse;
        this.difficulte = difficulte;
        this.nbPoseTotal = nbPoseTotal;
        this.nbRepCorrect = nbRepCorrect;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Enum getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(DifficultéEnum difficulte) {
        this.difficulte = difficulte;
    }

    public int getNbPoseTotal() {
        return nbPoseTotal;
    }

    public void setNbPoseTotal(int nbPoseTotal) {
        this.nbPoseTotal = nbPoseTotal;
    }

    public int getNbRepCorrect() {
        return nbRepCorrect;
    }

    public void setNbRepCorrect(int nbRepCorrect) {
        this.nbRepCorrect = nbRepCorrect;
    }
}
