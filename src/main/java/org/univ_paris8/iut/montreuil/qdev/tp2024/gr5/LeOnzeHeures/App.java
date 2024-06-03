package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.bo.QuestionBo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        String fichierCsv = "/home/etudiants/info/apons/prive/S4/BUT2-R4.02-2024-Alt-5_LeOnzeHeures-questionnaire-SME/src/main/java/org/univ_paris8/iut/montreuil/qdev/tp2024/gr5/LeOnzeHeures/quizz.csv";
        List<QuestionBo> questions = extraireQuestionnaire(fichierCsv);
        for (QuestionBo question : questions) {
            question.toString();
        }
    }

    private static List<QuestionBo> extraireQuestionnaire(String fichierCsv) {
        List<QuestionBo> questions = new ArrayList<QuestionBo>();
        try (CSVReader reader = new CSVReader(new FileReader(fichierCsv))) {
            String[] nextLine;
            reader.readNext(); // skip the header line
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length >= 8) {
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
                    System.out.println( "Hello World! 111" );
                    questions.add(question);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
