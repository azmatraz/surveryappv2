package model;

public class Answer {

    private int answerNo;
    private int questionNo;
    private String answer;
    private int rating;

    public Answer(String aNo, String qNo, String answer, String rating) {
        setAnswerNo(Integer.parseInt(aNo));
        setQuestionNo(Integer.parseInt(qNo));
        setAnswer(answer);
        setRating(Integer.parseInt(rating));
    }

    public int getAnswerNo() {
        return answerNo;
    }

    private void setAnswerNo(int answerNo) {
        this.answerNo = answerNo;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    private void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getAnswer() {
        return answer;
    }

    private void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getRating() {
        return rating;
    }

    private void setRating(int rating) {
        this.rating = rating;
    }

}
