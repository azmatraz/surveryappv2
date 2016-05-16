package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import model.SAppAnswer;
import model.SAppQuestion;

public class SurveyDAOImpl implements SurveyDAO {

    private DataSource dataSource;
    private static Logger log;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<SAppQuestion> getAllQuestions() {
        String query = "SELECT * FROM SAPPSAppQuestionS";
        List<SAppQuestion> SAppQuestionList = new ArrayList<SAppQuestion>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                SAppQuestionList.add(new SAppQuestion(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                                rs.getString(4)));
                log.info("SAppQuestion Found:" + SAppQuestionList.get(SAppQuestionList.size() - 1));
            }
        } catch (SQLException e) {
            log.error("Exception caught while trying to retrieve all SAppQuestions: " + e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                log.error("SQL EXception Caught closing connection: " + e.getMessage());
            }
        }
        return SAppQuestionList;
    }

    @Override
    public List<SAppAnswer> retrieveAllAnswersForQuestion(int SAppQuestionNo) {
        String query = "SELECT * FROM SAPPSAppAnswerS WHERE SAppQuestionNO LIKE ?";
        List<SAppAnswer> SAppAnswerList = new ArrayList<SAppAnswer>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, String.valueOf(SAppQuestionNo));
            rs = ps.executeQuery();
            while (rs.next()) {
                SAppAnswerList.add(new SAppAnswer(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),
                                Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5)));
                log.info("SAppQuestion Found::" + SAppAnswerList.get(SAppAnswerList.size() - 1));
            }
        } catch (SQLException e) {
            log.error("Exception caught while getting SAppAnswers to the SAppQuestion: " + e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                log.error("SQL EXception Caught closing connection: " + e.getMessage());
            }
        }
        return SAppAnswerList;
    }

    @Override
    public int submitQuestion(List<String> SAppQuestion) {
        String query = "INSERT INTO SAPPSAppQuestionS SAppQuestionNo, SAppQuestionTitle, SAppQuestionBody, Email VALUES ?, ?, ?, ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, SAppQuestion.get(0));
            ps.setString(2, SAppQuestion.get(1));
            ps.setString(3, SAppQuestion.get(2));
            ps.setString(4, SAppQuestion.get(3));
            rs = ps.executeQuery();
        } catch (SQLException e) {
            log.error("Exceptino caught while trying to insert a new SAppQuestion: " + e.getMessage());
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