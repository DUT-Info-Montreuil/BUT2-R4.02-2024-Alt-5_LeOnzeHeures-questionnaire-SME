package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.bo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class QuestionBo {
    private String idQuestionnaire;
    private String numeroQuestion;
    private String langue;
    private String libelle;
    private String reponse;
    private String difficulté;
    private String explication;
    private String reference;

    public QuestionBo(String idQuestionnaire, String numeroQuestion, String langue, String libelle, String reponse, String difficulté, String explication, String reference) {
        this.idQuestionnaire = idQuestionnaire;
        this.numeroQuestion = numeroQuestion;
        this.langue = langue;
        this.libelle = libelle;
        this.reponse = reponse;
        this.difficulté = difficulté;
        this.explication = explication;
        this.reference = reference;
    }

    public List<QuestionBo> extractionQuestionnaire (String fichierCsv){
        List<QuestionBo> questions = new ArrayList<QuestionBo>();
        try (CSVReader reader = new CSVReader(new FileReader(fichierCsv))) {
            String[] nextLine;
            reader.readNext(); // skip the header line
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length == 8) {
                    QuestionBo question = new QuestionBo(
                            nextLine[0], // idQuestionnaire
                            nextLine[1], // numeroQuestion
                            nextLine[2], // langue
                            nextLine[3], // libelle
                            nextLine[4], // reponse
                            nextLine[5], // difficulté
                            nextLine[6], // explication
                            nextLine[7]  // reference
                    );
                    questions.add(question);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public String getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(String idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getNumeroQuestion() {
        return numeroQuestion;
    }

    public void setNumeroQuestion(String numeroQuestion) {
        this.numeroQuestion = numeroQuestion;
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

    public String getDifficulté() {
        return difficulté;
    }

    public void setDifficulté(String difficulté) {
        this.difficulté = difficulté;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionBo that = (QuestionBo) o;
        return Objects.equals(idQuestionnaire, that.idQuestionnaire) && Objects.equals(numeroQuestion, that.numeroQuestion) && Objects.equals(langue, that.langue) && libelle.equals(that.libelle) && reponse.equals(that.reponse) && Objects.equals(difficulté, that.difficulté) && Objects.equals(explication, that.explication) && Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire, numeroQuestion, langue, libelle, reponse, difficulté, explication, reference);
    }

    @Override
    public String toString() {
        return "QuestionBo{" +
                "idQuestionnaire='" + idQuestionnaire + '\'' +
                ", numeroQuestion='" + numeroQuestion + '\'' +
                ", langue='" + langue + '\'' +
                ", libelle='" + libelle + '\'' +
                ", reponse='" + reponse + '\'' +
                ", difficulte='" + difficulté + '\'' +
                ", explication='" + explication + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
