package database.dao;

import model.SAppAnswer;
import model.SAppQuestions;
 

public interface SurveyDAO {
     

    public SAppQuestions getAllQuestions();

    public SAppAnswer retrieveAllAnswersForQuestion(String email);
    
}
