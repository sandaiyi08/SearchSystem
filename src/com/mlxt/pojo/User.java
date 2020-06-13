package com.mlxt.pojo;

import com.mlxt.common.utils.BasePojo;

/**
 * Filename: User.java
 * 
 * ·用户信息类
 * 
 * @author Luor
 * @version 1.0
 */
public class User extends BasePojo {
	private String password;
	private String tel;
	
	/**
	 * ·构造函数
	 */
	public User() {
		
	}
	
	/**
	 * ·构造函数
	 * 
	 * @param password
	 * @param tel
	 */
	public User(String password, String tel) {
		this.password = password;
		this.tel = tel;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", tel=" + tel + "]";
	}
}
