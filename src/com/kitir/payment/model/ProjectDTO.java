package com.kitir.payment.model;

import java.util.Date;

public class ProjectDTO {
	int n_project_no;
	String s_project_name;
	int target_price;
	int total_price;
	String l_description;
	String s_project_image;
	Date d_project_created;
	
	ProjectDTO(){
		
	}
	
	ProjectDTO(String s_project_name, int target_price){
		this.s_project_name = s_project_name;
		this.target_price = target_price;
	}
	
	public int getN_project_no() {
		return n_project_no;
	}
	public void setN_project_no(int n_project_no) {
		this.n_project_no = n_project_no;
	}
	public String getS_project_name() {
		return s_project_name;
	}
	public void setS_project_name(String s_project_name) {
		this.s_project_name = s_project_name;
	}
	public int getTarget_price() {
		return target_price;
	}
	public void setTarget_price(int target_price) {
		this.target_price = target_price;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getL_description() {
		return l_description;
	}
	public void setL_description(String l_description) {
		this.l_description = l_description;
	}
	public String getS_project_image() {
		return s_project_image;
	}
	public void setS_project_image(String s_project_image) {
		this.s_project_image = s_project_image;
	}
	public Date getD_project_created() {
		return d_project_created;
	}
	public void setD_project_created(Date d_project_created) {
		this.d_project_created = d_project_created;
	}
	
}
