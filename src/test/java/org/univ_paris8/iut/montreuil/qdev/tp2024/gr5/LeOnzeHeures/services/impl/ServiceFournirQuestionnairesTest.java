package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.impl;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.DifficultéEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.impl.mocks.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.models.IQuestionnaireService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceFournirQuestionnairesTest {
    private IQuestionnaireService serviceQuestionnaireImpl;
    @BeforeEach
    void setUp(TestInfo testInfo) throws Exception {

        serviceQuestionnaireImpl = null;

        System.out.println("test " + testInfo.getDisplayName());
    }

    // Test 1
    @Test
    public void fournirListeQuestionnaireOKTest() throws QuestionnaireVideException, ChampVideQuestionnaireException, ChampVideQuestionDTOException, FichierVideException, ChampVideQuestionBOException, FichierInaccessibleException, TypeEntreeIncompatibleException {
        // MOCK à supprimer lors de l'ajout du vrai service
        serviceQuestionnaireImpl = new ServiceFournirListeQuestionnairesMockOK();



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

        List<QuestionnaireDTO> listeAttendue = new ArrayList<>();
        listeAttendue.add(qstn1);
        listeAttendue.add(qstn2);

        try {
            List<QuestionnaireDTO> listeRésultat = serviceQuestionnaireImpl.fournirListeQuestionnaires("questionQuizz");
            System.out.println("listeAttendue : "+listeAttendue);
            System.out.println("listeRésultat : "+listeRésultat);
            assertEquals(listeAttendue.get(1),listeRésultat.get(2));
            assertEquals(listeAttendue.get(2),listeRésultat.get(1));
        }
        catch (Exception e) {
            System.out.println("Erreur inattendu dans le test fournirListeQuestionnaireOKTest");
        }
    }

    // Test 2
    @Test
    public void typeEntreeIncompatibleTest() {

        serviceQuestionnaireImpl = new ServiceFournirListeTypeEntreeIncompatibleMOCK();

        assertThrows(TypeEntreeIncompatibleException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz");
        });
    }

    // Test 3
    @Test
    public void questionBOChampVideTest() {

        serviceQuestionnaireImpl = new ServiceQuestionBOChampVideMOCK();

        assertThrows(ChampVideQuestionBOException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz");
        });
    }

    // Test 4
    @Test
    public void questionDTOChampVideTest() {

        serviceQuestionnaireImpl = new ServiceQuestionDTOChampVideMOCK();

        assertThrows(ChampVideQuestionDTOException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz");
        });
    }

    // Test 5
    @Test
    public void questionnaireChampVideTest() {

        serviceQuestionnaireImpl = new ServiceQuestionnaireChampVideMOCK();

        assertThrows(ChampVideQuestionnaireException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz");
        });
    }

    // Test 6
    @Test
    public void fichierIntrouvableTest() {

        serviceQuestionnaireImpl = new ServiceQuestionnaireFichierIntrouvableMOCK();

        assertThrows(FichierInaccessibleException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("quizzInaccessible");
        });
    }

    // Test 7
    @Test
    public void fichierVideTest() {

        serviceQuestionnaireImpl = new ServiceQuestionnaireFichierVideMOCK();

        assertThrows(FichierVideException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz");
        });
    }

    // Test 8
    @Test
    public void questionnaireSansQuestionTest() {

        serviceQuestionnaireImpl = new ServiceQuestionnaireSansQuestionMOCK();

        assertThrows(QuestionnaireVideException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz");
        });
    }
}
