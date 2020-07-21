package com.kitri.projectDetail.controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kitir.payment.view.PaymentService;
import com.kitri.projectDetail.model.ProjectInfoDAO;
import com.kitri.projectDetail.view.ImagePaint;
import com.kitri.projectDetail.view.ProjectDetailComponents;

public class ButtonActionListner extends JDialog implements ActionListener {
	String Dialogtitle;
	JFrame OriginalFrame;
	ProjectDetailComponents pjd;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	Properties properties = new Properties();
	String fname = "D:\\eclipse-workspace\\swingFunding\\src\\com\\kitri\\projectDetail\\model\\test.properties";

	JTextArea titleTextArea;
	JButton openBtn;
	JTextArea textArea;
	JPanel imgPanel;
	public String str;
	
	public void setPjd(ProjectDetailComponents pjd) {
		this.pjd = pjd;
		
	}
	public ButtonActionListner() {
	}
	
	public ButtonActionListner(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		Dialogtitle = title;
		OriginalFrame = owner;
		
		this.titleTextArea = pjd.titleTextArea;
		this.openBtn = pjd.openBtn;
		this.textArea = pjd.textArea;
		this.imgPanel = pjd.imgPanel;
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("DONATE")) {
			new PaymentService();
		}
		try {
			properties.load(new FileInputStream(fname));
			conn = DriverManager.getConnection(properties.getProperty("url"), 
					properties.getProperty("user"),
					properties.getProperty("passwd"));
			System.out.println("DB연결 성공");
		}catch(Exception e2) {
			System.out.println("Database 연결 실패"+e2);
		}
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select S_PROJECT_NAME, L_DESCRIPTION, S_PROJECT_IMAGE from TB_PROJECT_INFO where N_PROJECT_NO =2000";
			if(e.getSource()  == openBtn) {
				titleTextArea.setText("");
				if(titleTextArea.getText().equals("")) {
					
				}else {
					
				}
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					str = rs.getString("S_PROJECT_NAME");
					String str2 = rs.getString("L_DESCRIPTION");
					String str3 = rs.getString("S_PROJECT_IMAGE");
					
					ImagePaint panel = new ImagePaint(new ImageIcon("D:\\eclipse-workspace\\swingFunding\\src\\img\\"+str3).getImage());
					imgPanel.add(panel);
					titleTextArea.append(str);
					textArea.append(str2);
				}
			}
		}catch(Exception e2) {
			e2.printStackTrace();
			System.out.println("자료읽기 실패 : "+ e2);
		}finally {
			try {
				if (rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e3) {
			}
		}
	}

}
