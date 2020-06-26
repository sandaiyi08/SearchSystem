package com.mlxt.pojo;

import com.mlxt.common.utils.BasePojo;

/**
 * Filename: Family.java
 * 
 * ·家庭信息类
 * 
 * @author Luor
 * @version 1.0
 */
public class Family extends BasePojo {
	private String familyName;
	private String familyTel;
	private String familyTelModify;
	private Integer oldManId;
	private String oldManName;
	
	/**
	 * ·构造函数
	 */
	public Family() {
		
	}
	
	/**
	 * ·构造函数
	 * 
	 * @param familyTel
	 * @param familyName
	 * @param oldManId
	 */
	public Family(String familyTel, String familyName, Integer oldManId) {
		this.familyTel = familyTel;
		this.familyName = familyName;
		this.oldManId = oldManId;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the familyTel
	 */
	public String getFamilyTel() {
		return familyTel;
	}

	/**
	 * @param familyTel the familyTel to set
	 */
	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}

	/**
	 * @return the familyTelModify
	 */
	public String getFamilyTelModify() {
		return familyTelModify;
	}

	/**
	 * @param familyTelModify the familyTelModify to set
	 */
	public void setFamilyTelModify(String familyTelModify) {
		this.familyTelModify = familyTelModify;
	}

	/**
	 * @return the oldManId
	 */
	public Integer getOldManId() {
		return oldManId;
	}

	/**
	 * @param oldManId the oldManId to set
	 */
	public void setOldManId(Integer oldManId) {
		this.oldManId = oldManId;
	}

	/**
	 * @return the oldManName
	 */
	public String getOldManName() {
		return oldManName;
	}

	/**
	 * @param oldManName the oldManName to set
	 */
	public void setOldManName(String oldManName) {
		this.oldManName = oldManName;
	}

	@Override
	public String toString() {
		return "Family [familyName=" + familyName + ", familyTel=" + familyTel + ", familyTelModify=" + familyTelModify
				+ ", oldManId=" + oldManId + ", oldManName=" + oldManName + "]";
	}

}
