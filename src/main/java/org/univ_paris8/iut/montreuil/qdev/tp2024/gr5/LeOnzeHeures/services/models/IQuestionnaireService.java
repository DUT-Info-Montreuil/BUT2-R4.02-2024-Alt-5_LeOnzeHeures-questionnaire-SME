package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.models;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.FichierInaccessibleException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.TypeIncompatibleException;

import java.util.List;

public interface IQuestionnaireService {
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String urlFichier) throws FichierInaccessibleException, TypeIncompatibleException;
}
