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
	private String id;
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
	public OldMan(String address, String id, String imgPath, String name) {
		this.address = address;
		this.id = id;
		this.imgPath = imgPath;
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OldMan [address=" + address + ", id=" + id + ", imgPath=" + imgPath + ", name=" + name + "]";
	}
}
