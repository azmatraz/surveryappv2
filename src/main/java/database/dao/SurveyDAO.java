package database.dao;

import java.util.List;

import model.Answer;
import model.Question;

public interface SurveyDAO {

    public List<Question> getAllQuestions();

    public List<Answer> retrieveAllAnswersForQuestion(int questionNo);

    public int submitQuestion(List<String> question);

    public int selectOrCreateUser(String email);
}
