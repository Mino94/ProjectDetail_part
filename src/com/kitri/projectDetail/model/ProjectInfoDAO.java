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
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패" + e);
			System.exit(0);
		}
	}
	
}
