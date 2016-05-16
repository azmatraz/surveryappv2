package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import model.SAppQuestion;
import service.SurveyService;

public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @RequestMapping(value = "/api/v1/listQuestions")
    public String listQuestions(Map<String, Object> model) {
        List<SAppQuestion> qList = surveyService.listQuestions();
        model.put("questions", qList);
        return "/questions";
    }
}
