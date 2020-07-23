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
	// ResultSet : ������ �������� ���� �޴� ��ü
	ResultSet rs = null;
	Statement stmt = null; // �׳� �������°�
	// PreparedStatement�� �������� ?�� ����ؼ� �߰��� ?�� ������ �Ҵ��� �ټ� �ֵ��� �ϴ� ��ü
	PreparedStatement ps = null; // ?�־ ����ִ°�

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
			System.out.println("DB���� ����");
		}catch(Exception e2) {
			System.out.println("Database ���� ����"+e2);
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