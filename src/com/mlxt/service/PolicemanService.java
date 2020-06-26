package com.mlxt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mlxt.pojo.Image;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.Policeman;

/**
 * Filename: PolicemanService.java
 * 
 * ·警察业务层接口
 * 
 * @author Luor
 * @version 1.0
 */
public interface PolicemanService {
	
	/**
	 * ·警察登录
	 * @param account
	 * @param password
	 * @return
	 */
	public Policeman findPolice(@Param("account")String account,@Param("password")String password);
	
	/**
	 * ·识别老人信息
	 * @param oldManId
	 * @return
	 */
	public OldMan findOldmanById(@Param("oldManId")Integer oldManId);
	
	/**
	 * ·获取图片信息
	 * @return
	 */
	public List<Image> findImageList();
	
}
