package com.kitir.payment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaymentDAO {

	// Connection은 데이터베이스와 연결하는 객체이다.
	Connection conn = null;
	// ResultSet : 실행한 쿼리문의 값을 받는 객체
	ResultSet rs = null;
	Statement st = null; // 그냥 가져오는거
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement ps = null; // ?넣어서 집어넣는거

	// 생성자
	public PaymentDAO() {

		try {
			String user = "javauser";
			String pw = "12345";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			// jdbc drive를 등록하는 과정
			// class.forName을 호출하면 Driver가 자기자신을 초기화하여 DriverManager에 등록한다.
			// 즉, 개발자가 따로 관리하지 않는 static 객체들이 알아서 DriverManager에 등록되는 것이다.
			// 그래서 Class.forName()을 호출하고 나서 어떤 인자로도 전달하지 않고 바로 getConnection()을 호출해도 드라이버가 찾아진다.

			// Driver Class를 로딩하면 객체가 생성되고, DriverManager에 등록된다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// connection으로 db와 연결 (객체 생성)
			conn = DriverManager.getConnection(url, user, pw);

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
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
