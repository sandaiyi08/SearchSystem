package com.mlxt.pojo;

import com.mlxt.common.utils.BasePojo;

/**
 * Filename: Manager.java
 * 
 * ·管理员信息类
 * 
 * @author Luor
 * @version 1.0
 */
public class Manager extends BasePojo {
	private String account;
	private String password;
	
	/**
	 * ·构造函数
	 */
	public Manager() {
		
	}
	
	/**
	 * ·构造函数
	 * 
	 * @param account
	 * @param password
	 */
	public Manager(String account, String password) {
		this.account = account;
		this.password = password;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Manager [account=" + account + ", password=" + password + "]";
	}
}
