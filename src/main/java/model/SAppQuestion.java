package model;

public class SAppQuestion {

    private int questionNo;
    private String QuestionTitle;
    private String QuestionBody;
    private String Email;

    public SAppQuestion(int questionNo, String questionTitle, String questionBody, String email) {
        setQuestionNo(questionNo);
        setQuestionTitle(questionTitle);
        setQuestionBody(questionBody);
        setEmail(email);
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionTitle() {
        return QuestionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        QuestionTitle = questionTitle;
    }

    public String getQuestionBody() {
        return QuestionBody;
    }

    public void setQuestionBody(String questionBody) {
        QuestionBody = questionBody;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
