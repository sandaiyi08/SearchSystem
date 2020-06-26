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
	private String name;
	private String password;
	private String tel;
	private String telModify;

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
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the telModify
	 */
	public String getTelModify() {
		return telModify;
	}

	/**
	 * @param telModify the telModify to set
	 */
	public void setTelModify(String telModify) {
		this.telModify = telModify;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", tel=" + tel + ", telModify=" + telModify + "]";
	}
	
}
