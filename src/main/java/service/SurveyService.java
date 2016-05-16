package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.SurveyDAO;
import model.Question;

public class SurveyService {

    @Autowired
    SurveyDAO surveyDao;

    public List<Question> listQuestions() {
        return surveyDao.getAllQuestions();
    }
}
