package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import database.dao.SurveyDAO;
import model.SAppQuestion;

public class SurveyService {

    @Autowired
    SurveyDAO surveyDao;

    public List<SAppQuestion> listQuestions() {
        return surveyDao.getAllQuestions();
    }
}
