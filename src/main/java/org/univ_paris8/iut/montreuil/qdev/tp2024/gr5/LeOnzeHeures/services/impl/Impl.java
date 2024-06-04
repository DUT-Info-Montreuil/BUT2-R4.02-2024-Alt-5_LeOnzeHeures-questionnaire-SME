package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.bo.QuestionBo;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.models.IQuestionnaireService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.FichierInaccessibleException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.TypeEntreeIncompatibleException;

import java.util.List;

public class Impl implements IQuestionnaireService {
    private static Impl instance;
    private List<QuestionBo> questionsBO;
    public Impl(List<QuestionBo> questions){
        this.questionsBO = questions;
    }
    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String urlFichier) throws FichierInaccessibleException, TypeEntreeIncompatibleException {
        return null;
    }

    public static Impl getInstance(List<QuestionBo> questions) {
        if (instance == null) {
            instance = new Impl(questions);
        }
        return instance;
    }
}
