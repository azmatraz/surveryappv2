package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import model.Answer;
import model.Question;

public class SurveyDAOImpl implements SurveyDAO {

    private DataSource dataSource;
    private static Logger log;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Question> getAllQuestions() {
        String query = "SELECT * FROM SAPPQUESTIONS";
        List<Question> questionList = new ArrayList<Question>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                questionList.add(new Question(rs.getString(1), rs.getString(2), rs.getString(3)));
                log.info("Question Found:" + questionList.get(questionList.size() - 1));
            }
        } catch (SQLException e) {
            log.error("Exception caught while trying to retrieve all questions: " + e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                log.error("SQL EXception Caught closing connection: " + e.getMessage());
            }
        }
        return questionList;
    }

    @Override
    public List<Answer> retrieveAllAnswersForQuestion(int questionNo) {
        String query = "SELECT * FROM SAPPANSWERS WHERE QUESTIONNO LIKE ?";
        List<Answer> answerList = new ArrayList<Answer>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, String.valueOf(questionNo));
            rs = ps.executeQuery();
            while (rs.next()) {
                answerList.add(new Answer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                log.info("Question Found::" + answerList.get(answerList.size() - 1));
            }
        } catch (SQLException e) {
            log.error("Exception caught while getting answers to the question: " + e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                log.error("SQL EXception Caught closing connection: " + e.getMessage());
            }
        }
        return answerList;
    }

    @Override
    public int submitQuestion(List<String> question) {
        String query = "INSERT INTO SAPPQUESTIONS QuestionNo, QuestionTitle, QuestionBody, Email VALUES ?, ?, ?, ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, question.get(0));
            ps.setString(2, question.get(1));
            ps.setString(3, question.get(2));
            ps.setString(4, question.get(3));
            rs = ps.executeQuery();
        } catch (SQLException e) {
            log.error("Exceptino caught while trying to insert a new question: " + e.getMessage());
            return 1;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                log.error("SQL EXception Caught closing connection: " + e.getMessage());
                return 2;
            }
        }
        return 0;
    }

    @Override
    public int selectOrCreateUser(String email) {
        String query = "SELECT COUNT * FROM SAPPUSERS WHERE EMAIL = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);

            rs = ps.executeQuery();
            if (!rs.next()) {
                insertUser(email);
            }
        } catch (SQLException e) {
            log.error("Exception while trying to select user: " + e.getMessage());
            return 1;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                log.error("SQL EXception Caught closing connection: " + e.getMessage());
                return 2;
            }
        }
        return 0;
    }

    private int insertUser(String email) {
        String query = "INSERT INTO SAPPUSERS EMAIL VALUES (?)";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);

            rs = ps.executeQuery();
        } catch (SQLException e) {
            log.error("Exception while trying to insert user: " + e.getMessage());
            return 1;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                log.error("SQL EXception Caught closing connection: " + e.getMessage());
                return 2;
            }
        }
        return 0;
    }

}