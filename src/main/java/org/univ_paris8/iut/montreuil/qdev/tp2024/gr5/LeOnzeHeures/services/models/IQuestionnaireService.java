package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.models;

import com.opencsv.exceptions.CsvValidationException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.*;

import java.io.IOException;
import java.util.List;

public interface IQuestionnaireService {
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String urlFichier) throws QuestionnairesNonValideException, CsvValidationException, IOException;
}
