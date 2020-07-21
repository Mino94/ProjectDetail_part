package com.kitir.payment.model;

import java.sql.Date;

public class PaymentDTO {
//	CREATE TABLE TB_FUNDING_HISTORY(
//		    N_FUNDING_NO NUMBER(10) CONSTRAINT PK_TB_FUNDING_HISTORY PRIMARY KEY,
//		    N_FUNDING_PRICE NUMBER(10),
//		    D_FUNDING_HISTORY DATE,
//		    N_PROJECT_NO NUMBER(10),
//		    N_USER_NO NUMBER(3),
//		    N_ACCOUNT_NO NUMBER(20),
//		    S_ACCOUNTHOLDER VARCHAR2(10),
//		    S_BANK VARCHAR2(10),
//		    S_PAYTOOL VARCHAR2(10)
//		);
	int N_FUNDING_NO;
	int N_FUNDING_PRICE;
	Date D_FUNDING_HISTORY;
	int N_ACCOUNT_NO;
	String S_ACCOUNTHOLDER;
	String S_BANK;
	String S_PAYTOOL;
	
	public PaymentDTO() {
		
	}
	public PaymentDTO(int N_FUNDING_PRICE) {
		this.N_FUNDING_PRICE = N_FUNDING_PRICE;
	}
	public PaymentDTO(int N_FUNDING_PRICE, Date D_FUNDING_HISTORY,int N_ACCOUNT_NO,String S_ACCOUNTHOLDER,String S_BANK,String S_PAYTOOL) {
		this.N_FUNDING_PRICE = N_FUNDING_PRICE;
		this.D_FUNDING_HISTORY = D_FUNDING_HISTORY;
		this.N_ACCOUNT_NO = N_ACCOUNT_NO;
		this.S_ACCOUNTHOLDER = S_ACCOUNTHOLDER;
		this.S_BANK = S_BANK;
		this.S_PAYTOOL = S_PAYTOOL;
	}
	public int getN_FUNDING_NO() {
		return N_FUNDING_NO;
	}
	public void setN_FUNDING_NO(int n_FUNDING_NO) {
		N_FUNDING_NO = n_FUNDING_NO;
	}
	public int getN_FUNDING_PRICE() {
		return N_FUNDING_PRICE;
	}
	public void setN_FUNDING_PRICE(int n_FUNDING_PRICE) {
		N_FUNDING_PRICE = n_FUNDING_PRICE;
	}
	public Date getD_FUNDING_HISTORY() {
		return D_FUNDING_HISTORY;
	}
	public void setD_FUNDING_HISTORY(Date d_FUNDING_HISTORY) {
		D_FUNDING_HISTORY = d_FUNDING_HISTORY;
	}
	public int getN_ACCOUNT_NO() {
		return N_ACCOUNT_NO;
	}
	public void setN_ACCOUNT_NO(int n_ACCOUNT_NO) {
		N_ACCOUNT_NO = n_ACCOUNT_NO;
	}
	public String getS_ACCOUNTHOLDER() {
		return S_ACCOUNTHOLDER;
	}
	public void setS_ACCOUNTHOLDER(String s_ACCOUNTHOLDER) {
		S_ACCOUNTHOLDER = s_ACCOUNTHOLDER;
	}
	public String getS_BANK() {
		return S_BANK;
	}
	public void setS_BANK(String s_BANK) {
		S_BANK = s_BANK;
	}
	public String getS_PAYTOOL() {
		return S_PAYTOOL;
	}
	public void setS_PAYTOOL(String s_PAYTOOL) {
		S_PAYTOOL = s_PAYTOOL;
	}
	
	
}
