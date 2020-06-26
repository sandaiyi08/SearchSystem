package com.mlxt.pojo;

import com.mlxt.common.utils.BasePojo;

/**
 * °§Õº∆¨–≈œ¢¿‡
 * Filename: Image.java
 * 
 * @author Luor
 * @version 1.0
 */
public class Image extends BasePojo {
	private Integer id;
	private String imgPath;
	private String imgLocation;
	
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
	 * @return the imgLocation
	 */
	public String getImgLocation() {
		return imgLocation;
	}
	/**
	 * @param imgLocation the imgLocation to set
	 */
	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}
	
	@Override
	public String toString() {
		return "Image [id=" + id + ", imgPath=" + imgPath + ", imgLocation=" + imgLocation + "]";
	}
	
}
