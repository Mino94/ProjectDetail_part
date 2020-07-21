package com.kitir.payment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaymentDAO {

	// Connection�� �����ͺ��̽��� �����ϴ� ��ü�̴�.
	Connection conn = null;
	// ResultSet : ������ �������� ���� �޴� ��ü
	ResultSet rs = null;
	Statement st = null; // �׳� �������°�
	// PreparedStatement�� �������� ?�� ����ؼ� �߰��� ?�� ������ �Ҵ��� �ټ� �ֵ��� �ϴ� ��ü
	PreparedStatement ps = null; // ?�־ ����ִ°�

	// ������
	public PaymentDAO() {

		try {
			String user = "javauser";
			String pw = "12345";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			// jdbc drive�� ����ϴ� ����
			// class.forName�� ȣ���ϸ� Driver�� �ڱ��ڽ��� �ʱ�ȭ�Ͽ� DriverManager�� ����Ѵ�.
			// ��, �����ڰ� ���� �������� �ʴ� static ��ü���� �˾Ƽ� DriverManager�� ��ϵǴ� ���̴�.
			// �׷��� Class.forName()�� ȣ���ϰ� ���� � ���ڷε� �������� �ʰ� �ٷ� getConnection()�� ȣ���ص� ����̹��� ã������.

			// Driver Class�� �ε��ϸ� ��ü�� �����ǰ�, DriverManager�� ��ϵȴ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// connection���� db�� ���� (��ü ����)
			conn = DriverManager.getConnection(url, user, pw);

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
	}
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}

	public void insertData(PaymentDTO data) {
		try {
			String sql = "insert into TB_FUNDING_HISTORY(N_FUNDING_NO,N_FUNDING_PRICE,D_FUNDING_HISTORY,N_ACCOUNT_NO,S_ACCOUNTHOLDER,S_BANK,S_PAYTOOL) "
					+ "values(SEQ_FUNDING.nextval,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, data.N_FUNDING_PRICE);
			ps.setDate(2, data.D_FUNDING_HISTORY);
			ps.setInt(3, data.N_ACCOUNT_NO);
			ps.setString(4, data.S_ACCOUNTHOLDER);
			ps.setString(5, data.S_BANK);
			ps.setString(6, data.S_PAYTOOL);
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public ArrayList<ProjectDTO> pjdReadData() {
		ArrayList<ProjectDTO> arr = new ArrayList<ProjectDTO>();
		try {
			st = conn.createStatement();
			String sql = "select * from TB_PROJECT_INFO";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				arr.add(new ProjectDTO(rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	public int sumReadData() {
		int result =0;
		try {
			st = conn.createStatement();
			String sumSql = "SELECT SUM(N_FUNDING_PRICE) FROM TB_FUNDING_HISTORY GROUP BY N_PROJECT_NO";
			rs = st.executeQuery(sumSql);
			while(rs.next()) {
				result = rs.getInt("SUM(N_FUNDING_PRICE)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}

}
