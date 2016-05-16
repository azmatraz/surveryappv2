package model;

public class SAppAnswer {

    private int answerNo;
    private int questionNo;
    int rating;
    private String answerBody;
    private String email;

    public SAppAnswer(int answerNo, int questionNo, int rating, String answerBody, String email) {
        setAnswerNo(answerNo);
        setQuestionNo(questionNo);
        setRating(rating);
        setAnswerBody(answerBody);
        setEmail(email);
    }

    public int getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(int answerNo) {
        this.answerNo = answerNo;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAnswerBody() {
        return answerBody;
    }

    public void setAnswerBody(String answerBody) {
        this.answerBody = answerBody;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
