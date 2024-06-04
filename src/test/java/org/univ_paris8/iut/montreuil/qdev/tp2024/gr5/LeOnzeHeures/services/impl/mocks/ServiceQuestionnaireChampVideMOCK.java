package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.services.models.IQuestionnaireService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.utils.exceptions.*;
import java.util.List;

public class ServiceQuestionnaireChampVideMOCK implements IQuestionnaireService {
    public ServiceQuestionnaireChampVideMOCK() {
    }

    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String urlFichier) throws ChampVideQuestionBOException, ChampVideQuestionDTOException, ChampVideQuestionnaireException, FichierInaccessibleException, FichierVideException, QuestionnaireVideException, TypeEntreeIncompatibleException{
        throw new ChampVideQuestionnaireException();
    }
}