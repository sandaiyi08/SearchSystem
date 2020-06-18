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
	private String familyTel;
	private String familyName;
	private Integer oldManId;
	
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
	
	public String getFamilyTel() {
		return familyTel;
	}
	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public Integer getOldManId() {
		return oldManId;
	}
	public void setOldManId(Integer oldManId) {
		this.oldManId = oldManId;
	}

	@Override
	public String toString() {
		return "Family [familyTel=" + familyTel + ", familyName=" + familyName + ", oldManId=" + oldManId + "]";
	}
}
