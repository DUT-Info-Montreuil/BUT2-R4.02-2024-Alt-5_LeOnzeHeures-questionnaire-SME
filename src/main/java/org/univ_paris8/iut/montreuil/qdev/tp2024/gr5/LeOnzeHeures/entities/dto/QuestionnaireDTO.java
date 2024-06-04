package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionnaireDTO {
    private int numeroQuestionnaire;
    private List<QuestionDTO> listQuestionDTOS;
    private int nbQuestionnaireJoué;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireDTO that = (QuestionnaireDTO) o;
        return numeroQuestionnaire == that.numeroQuestionnaire && listQuestionDTOS.equals(that.listQuestionDTOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroQuestionnaire, listQuestionDTOS);
    }

    public QuestionnaireDTO(int numeroQuestionnaire) {
        this.numeroQuestionnaire = numeroQuestionnaire;
        this.listQuestionDTOS = new ArrayList<QuestionDTO>();
        this.nbQuestionnaireJoué = 0;
    }

    public void ajouterQuestion(QuestionDTO q){
        listQuestionDTOS.add(q);
    }

    public int getNumeroQuestionnaire() {
        return numeroQuestionnaire;
    }

    public void setNumeroQuestionnaire(int numeroQuestionnaire) {
        this.numeroQuestionnaire = numeroQuestionnaire;
    }

    public List<QuestionDTO> getListQuestions() {
        return listQuestionDTOS;
    }

    public void setListQuestions(List<QuestionDTO> listQuestionDTOS) {
        this.listQuestionDTOS = listQuestionDTOS;
    }

    public int getNbQuestionnaireJoué() {
        return nbQuestionnaireJoué;
    }

    public void setNbQuestionnaireJoué(int nbQuestionnaireJoué) {
        this.nbQuestionnaireJoué = nbQuestionnaireJoué;
    }
}
