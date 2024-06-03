package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.DifficultéEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.models.IQuestionnaireService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ServiceFournirListeQuestionnairesMockOK implements IQuestionnaireService {
    public ServiceFournirListeQuestionnairesMockOK(){

    }
    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String urlFichier) throws ChampVideQuestionBOException, ChampVideQuestionDTOException, ChampVideQuestionnaireException, FichierInaccessibleException, FichierVideException, QuestionnaireVideException, TypeEntreeIncompatibleException {

        QuestionDTO q1 = new QuestionDTO(1, "fr", "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", "Tee", DifficultéEnum.Intermédiaire, 1, 0);
        QuestionDTO q2 = new QuestionDTO(2, "fr", "Quel sport de raquette porte le nom de la ville anglaise où il fut inventé ?", "Badminton", DifficultéEnum.Expert, 1, 0);
        QuestionDTO q3 = new QuestionDTO(3, "fr", "Combien y a-t-il de joueurs sur le terrain dans une équipe de football ?", "Onze", DifficultéEnum.Simple, 1, 0);
        QuestionDTO q4 = new QuestionDTO(4, "fr", "Quel tapis à ressorts sert au gymnaste à faire toutes sortes de figures ?", "Trampoline", DifficultéEnum.Intermédiaire, 1, 0);

        QuestionnaireDTO qstn1 = new QuestionnaireDTO(1);
        QuestionnaireDTO qstn2 = new QuestionnaireDTO(2);

        qstn1.ajouterQuestion(q1);
        qstn1.ajouterQuestion(q2);
        qstn2.ajouterQuestion(q3);
        qstn2.ajouterQuestion(q4);

        List<QuestionnaireDTO> listQuestionnaire = new ArrayList<>();
        listQuestionnaire.add(qstn1);
        listQuestionnaire.add(qstn2);

        return listQuestionnaire;
    }

}
