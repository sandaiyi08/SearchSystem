package com.mlxt.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
	//警察登录
	public Policeman findPolice(@Param("account")String account,@Param("password")String password);
	//警察删除
	public Integer deletePolice(String account);
	//识别老人信息
	public OldMan findOldman(OldMan oldman);
}
