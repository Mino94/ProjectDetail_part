package com.kitir.payment.model;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kitri.projectDetail.view.ImagePaint;
import com.kitri.projectDetail.view.ProjectDetailComponents;

public class PaymentDAO {
	// Connection은 데이터베이스와 연결하는 객체이다.
	Connection conn = null;
	// ResultSet : 실행한 쿼리문의 값을 받는 객체
	ResultSet rs = null;
	Statement st = null; // 그냥 가져오는거
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement ps = null; // ?넣어서 집어넣는거
	
	public ArrayList<ProjectDTO> arr2;

	// 생성자
	public PaymentDAO() {
		try {
			String user = "javauser";
			String pw = "12345";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
	public ArrayList<ProjectDTO> getArr2() {
			return arr2;
	}
	public void setArr2(ArrayList<ProjectDTO> arr2) {
		this.arr2 = arr2;
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
	public ArrayList<ProjectDTO> readData(String i) {
		this.arr2 = new ArrayList<ProjectDTO>();
		try {
			st = conn.createStatement();

			String sql = "select * from TB_PROJECT_INFO where N_PROJECT_NO ="+i;	
			System.out.println(sql);
			rs=st.executeQuery(sql);
			while(rs.next()){

				
//				imgPanel.add(panel);
//				titleTextArea.append(str);
//				textArea.append(str2);
				arr2.add(new ProjectDTO(rs.getString(2),rs.getString(5),rs.getString(6)));
		        ProjectDetailComponents pjd = new ProjectDetailComponents();
		        ImagePaint panel = new ImagePaint(new ImageIcon("D:\\eclipse-workspace\\swingFunding\\src\\img\\"+rs.getString(6)).getImage());
		        if(pjd == null) {
		        	pjd.getTitleTextArea().append(rs.getString(2));
		    		pjd.getTextArea().append(rs.getString(5));
		        	pjd.getImgPanel().add(panel);
		        }
				System.out.println(rs.getString(2)+" "+rs.getString(5) +" "+rs.getString(6));
			}
		}catch(Exception e2) {
			e2.printStackTrace();
			System.out.println("자료읽기 실패 : "+ e2);
		}finally {
			try {
				if (rs != null) rs.close();
				if(st != null) st.close();
				if(ps != null) ps.close();
			} catch (Exception e3) {
			}
		}
		return arr2;
	}
	


}
