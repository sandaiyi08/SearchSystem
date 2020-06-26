package com.mlxt.pojo;

import com.mlxt.common.utils.BasePojo;

/**
 * Filename: OldMan.java
 * 
 * ·老人信息类
 * 
 * @author Luor
 * @version 1.0
 */
public class OldMan extends BasePojo {
	private String address;
	private String faceLocation;
	private String fmName;
	private String fmTel;
	private Integer id;
	private String imgPath;
	private String name;
	
	/**
	 * ·构造函数
	 */
	public OldMan() {
		
	}
	
	/**
	 * ·构造函数
	 * 
	 * @param address
	 * @param id
	 * @param imgPath
	 * @param name
	 */
	public OldMan(String address, Integer id, String imgPath, String name) {
		this.address = address;
		this.id = id;
		this.imgPath = imgPath;
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the faceLocation
	 */
	public String getFaceLocation() {
		return faceLocation;
	}

	/**
	 * @param faceLocation the faceLocation to set
	 */
	public void setFaceLocation(String faceLocation) {
		this.faceLocation = faceLocation;
	}
	
	/**
	 * @return the fm_name
	 */
	public String getFmName() {
		return fmName;
	}

	/**
	 * @param fm_name the fm_name to set
	 */
	public void setFmName(String fmName) {
		this.fmName = fmName;
	}
	
	/**
	 * @return the fm_tel
	 */
	public String getFmTel() {
		return fmTel;
	}

	/**
	 * @param fm_tel the fm_tel to set
	 */
	public void setFmTel(String fmTel) {
		this.fmTel = fmTel;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param imgPath the imgPath to set
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
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

	@Override
	public String toString() {
		return "OldMan [address=" + address + ", faceLocation=" + faceLocation + ", id=" + id + ", imgPath=" + imgPath
				+ ", name=" + name + "]";
	}

}
