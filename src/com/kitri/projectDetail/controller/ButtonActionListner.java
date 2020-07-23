package com.kitri.projectDetail.controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	Connection conn = null;
	// ResultSet : 실행한 쿼리문의 값을 받는 객체
	ResultSet rs = null;
	Statement stmt = null; // 그냥 가져오는거
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement ps = null; // ?넣어서 집어넣는거

	Properties properties = new Properties();
	String fname = "D:\\eclipse-workspace\\swingFunding\\src\\com\\kitri\\projectDetail\\model\\test.properties";

	JTextArea titleTextArea= null;
	JButton openBtn= null;
	JTextArea textArea= null;
	JPanel imgPanel= null;
	public String str= null;

	public void setPjd(ProjectDetailComponents pjd) {
		this.pjd = pjd;

	}
	public ButtonActionListner() {
		try {
			properties.load(new FileInputStream(fname));
			conn = DriverManager.getConnection(properties.getProperty("url"), 
					properties.getProperty("user"),
					properties.getProperty("passwd"));
			System.out.println("DB연결 성공");
		}catch(Exception e2) {
			System.out.println("Database 연결 실패"+e2);
		}
	}

	public ButtonActionListner(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		Dialogtitle = title;
		OriginalFrame = owner;

		this.titleTextArea = pjd.titleTextArea;

		this.textArea = pjd.textArea;
		this.imgPanel = pjd.imgPanel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("DONATE")) {
			new PaymentService();
		}

	}
//	public void readData(String i) {
//		
		
//	}
}