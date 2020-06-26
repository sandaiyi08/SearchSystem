package com.mlxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.Image;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.Policeman;

/**
 * Filename: PolicemanDao.java
 * 
 * ·警察数据访问层
 * 
 * @author Luor
 * @version 1.0
 */

@Repository
public interface PolicemanDao {
	
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
