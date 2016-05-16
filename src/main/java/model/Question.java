package model;

public class Question {

    private int questionNo;
    private String questionTitle;
    private String questionBody;

    public Question(String qNo, String qT, String qB) {
        setQuestionNo(Integer.parseInt(qNo));
        setQuestionTitle(qT);
        setQuestionBody(qB);
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

}
