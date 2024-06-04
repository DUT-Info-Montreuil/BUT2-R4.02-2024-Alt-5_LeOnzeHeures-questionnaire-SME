package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.impl;

import com.opencsv.exceptions.CsvValidationException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.bo.QuestionBo;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.mappers.Mappers;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.models.IQuestionnaireService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.FichierInaccessibleException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.QuestionnairesNonValideException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.TypeEntreeIncompatibleException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Impl implements IQuestionnaireService {
    private static Impl instance;

    public Impl(){
    }
    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String urlFichier) throws QuestionnairesNonValideException, CsvValidationException, IOException {
        QuestionBo questionBo = new QuestionBo(null, null, null, null,null, null, null, null);
        List<QuestionBo> listeBO = new ArrayList<>();
        List<QuestionDTO> listeDTO = new ArrayList<>();
        List<QuestionnaireDTO> ListeQuestionnaireDTO = new ArrayList<>();
        listeBO = questionBo.extractionQuestionnaire(urlFichier);
        for (QuestionBo question : listeBO) {
            Mappers mappers = new Mappers(question);
            listeDTO.add(mappers.toDTO());
        }

        for (QuestionDTO question : listeDTO ) {
            QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO(question.getNumero());
            ListeQuestionnaireDTO.add(questionnaireDTO);
        }
        return ListeQuestionnaireDTO;
    }

    public static Impl getInstance(List<QuestionBo> questions) {
        if (instance == null) {
            instance = new Impl();
        }
        return instance;
    }
}
