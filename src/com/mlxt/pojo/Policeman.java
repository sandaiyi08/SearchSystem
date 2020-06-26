package com.mlxt.pojo;

import com.mlxt.common.utils.BasePojo;

/**
 * Filename: Policeman.java
 * 
 * ��������Ϣ��
 * 
 * @author Luor
 * @version 1.0
 */
public class Policeman extends BasePojo {
	private String account;
	private String password;
	
	/**
	 * �����캯��
	 */
	public Policeman() {
		
	}
	
	/**
	 * �����캯��
	 * 
	 * @param account
	 * @param password
	 */
	public Policeman(String account, String password) {
		this.account = account;
		this.password = password;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Policeman [account=" + account + ", password=" + password + "]";
	}
}
