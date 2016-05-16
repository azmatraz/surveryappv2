package database.dao;

import java.util.List;

import model.SAppAnswer;
import model.SAppQuestion;

public interface SurveyDAO {

    public List<SAppQuestion> getAllQuestions();

    public List<SAppAnswer> retrieveAllAnswersForQuestion(int questionNo);

    public int submitQuestion(List<String> question);

    public int selectOrCreateUser(String email);
}
