package com.kitri.projectDetail.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ProjectInfoDAO {

	Properties properties = new Properties();
	String fname = "D:\\eclipse-workspace\\swingFunding\\src\\com\\kitri\\projectDetail\\model\\test.properties";
	
	public ProjectInfoDAO(){
		try {
			properties.load(new FileInputStream(fname));
			Class.forName(properties.getProperty("driver"));
			System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			System.out.println("����̹� �ε� ����" + e);
			System.exit(0);
		}
	}
	
}
