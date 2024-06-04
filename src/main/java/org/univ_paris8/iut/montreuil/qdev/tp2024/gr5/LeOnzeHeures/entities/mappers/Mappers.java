package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.mappers;


import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.bo.QuestionBo;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.DifficultéEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.dto.QuestionDTO;

public class Mappers {

    private QuestionBo questionBo;
    public Mappers(QuestionBo questionBo){
        this.questionBo = questionBo;
    }

    public QuestionDTO toDTO (){
        int numero = Integer.parseInt(this.questionBo.getNumeroQuestion());
        String langue = this.questionBo.getLangue();
        String libelle = this.questionBo.getLibelle();
        String reponse = this.questionBo.getReponse();
        DifficultéEnum difficulté = mapDifficulté(this.questionBo.getDifficulté());
        int nbPoseTotal = 0;
        int nbRepCorrect = 0;
        return new QuestionDTO(numero, langue, libelle, reponse, difficulté, nbPoseTotal, nbRepCorrect);
    }

    private DifficultéEnum mapDifficulté(String difficulté) {
        switch (difficulté.toLowerCase()) {
            case "facile":
                return DifficultéEnum.Simple;
            case "moyen":
                return DifficultéEnum.Intermédiaire;
            case "difficile":
                return DifficultéEnum.Expert;
            default:
                throw new IllegalArgumentException("Difficulté inconnue: " + difficulté);
        }
    }
}
