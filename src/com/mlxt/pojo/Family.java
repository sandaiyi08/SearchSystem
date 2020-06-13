package com.mlxt.pojo;

import com.mlxt.common.utils.BasePojo;

/**
 * Filename: Family.java
 * 
 * ����ͥ��Ϣ��
 * 
 * @author Luor
 * @version 1.0
 */
public class Family extends BasePojo {
	private String familyTel;
	private String familyName;
	private String oldManId;
	
	/**
	 * �����캯��
	 */
	public Family() {
		
	}
	
	/**
	 * �����캯��
	 * 
	 * @param familyTel
	 * @param familyName
	 * @param oldManId
	 */
	public Family(String familyTel, String familyName, String oldManId) {
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
	public String getOldManId() {
		return oldManId;
	}
	public void setOldManId(String oldManId) {
		this.oldManId = oldManId;
	}

	@Override
	public String toString() {
		return "Family [familyTel=" + familyTel + ", familyName=" + familyName + ", oldManId=" + oldManId + "]";
	}
}
