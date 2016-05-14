package database.dao;

import database.model.Customer;

import javax.sql.DataSource;

import model.Answer;
import model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyDAOImpl implements SurveyDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Customer getByWebQuoteReferenceNumber(String web_quote_reference_number) {
		// String query = "select name, role from Customer where id = ?";
		String query = "SELECT c.client_reference_number FROM quote_policy_link qpl, client c WHERE qpl.client_identifier = c.client_identifier AND qpl.web_quote_reference_number = ? AND qpl.policy_number is not null FETCH FIRST 1 ROWS ONLY";
		Customer emp = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, web_quote_reference_number);
			rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Customer();
				emp.setId(web_quote_reference_number);
				emp.setClient_reference_number(rs.getInt("client_reference_number"));
				System.out.println("Customer Found::" + emp);
			} else {
				System.out.println("No Customer found with id=" + web_quote_reference_number);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	public Customer retrievePolicyNumberAndDatOfBirth() {

		String query = "SELECT * FROM (SELECT qpl.quote_reference_number,qpl.quote_version_number,qph.reference_policy_number, c.client_reference_number, iv.birth_date, qpl.create_date_time, qph.policy_effective_from_date, qph.total_premium, lk.short_description FROM quote_policy_link    qpl,quote_policy_header      qph, quote_policy_transaction qpt, lk_code_detail lk, client  c, individual  iv WHERE qpl.quote_policy_link_id = qph.quote_policy_link_id AND qpl.client_identifier = c.client_identifier AND c.party_identifier = iv.individual_identifier AND qpl.quote_policy_link_id = qpt.quote_policy_link_id AND qpt.lk_transaction_identifier = 13366 AND qph.payment_method_identifier = lk.lk_code_detail_identifier AND qph.quote_type_identifier = 102603 AND qph.payment_method_identifier = 33802 AND qpl.status_identifier IN (37102) AND qpl.product_master_identifier = 1 AND rownum <= 10 ORDER BY dbms_random.random) WHERE rownum <= 1";

		Customer emp = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Customer();
				emp.setReferencePolicyNumber(rs.getString("reference_policy_number"));
				emp.setDateOfBirth(rs.getDate("birth_date").toString());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;

	}


	public Customer getByWebPolicyNumberAndDOBNearRenewal() {
		String query = "SELECT * FROM (SELECT qpl.quote_reference_number,qpl.quote_version_number,qph.reference_policy_number, c.client_reference_number, iv.birth_date, qpl.create_date_time, qph.policy_effective_from_date, qph.total_premium, lk.short_description FROM quote_policy_link    qpl,quote_policy_header      qph, quote_policy_transaction qpt, lk_code_detail lk, client  c, individual  iv WHERE qpl.quote_policy_link_id = qph.quote_policy_link_id AND qpl.client_identifier = c.client_identifier AND c.party_identifier = iv.individual_identifier AND qpl.quote_policy_link_id = qpt.quote_policy_link_id AND qpt.lk_transaction_identifier = 13366 AND qph.payment_method_identifier = lk.lk_code_detail_identifier AND qph.quote_type_identifier = 102603 AND qph.payment_method_identifier = 33802 AND qpl.status_identifier IN (37102) AND qpl.product_master_identifier = 1 AND trunc(qph.policy_effective_from_date) = TRUNC(SYSDATE+4) AND rownum <= 10 ORDER BY dbms_random.random) WHERE rownum <= 1";
		Customer emp = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Customer();
				emp.setReferencePolicyNumber(rs.getString("reference_policy_number"));
				emp.setDateOfBirth(rs.getDate("birth_date").toString());
			} else {
				// System.out.println("No Policy found with id="+policyNumber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;

	}

	@Override
	public Question getAllQuestions() {
		String query = "SELECT * FROM SAPPQUESTION"
		Question question = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				question = new Customer();
				question.setId(web_quote_reference_number);
				question.setClient_reference_number(rs.getInt("client_reference_number"));
				System.out.println("Customer Found::" + emp);
			} else {
				System.out.println("No Customer found with id=" + web_quote_reference_number);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Answer retrieveAllAnswersForQuestion(String email) {
		// TODO Auto-generated method stub
		return null;
	}



	
	

}