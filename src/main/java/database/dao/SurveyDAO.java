package database.dao;

import java.util.List;

import model.Answer;
import model.Question;
import database.model.Customer;
 

public interface SurveyDAO {
     

    public Question getAllQuestions();

    public Answer retrieveAllAnswersForQuestion(String email);
    
}
