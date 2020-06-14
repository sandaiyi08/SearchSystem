package com.mlxt.service;

import org.apache.ibatis.annotations.Param;

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
	//警察登录
	public Policeman findPolice(@Param("account")String account,@Param("password")String password);
	//警察删除
	public Integer deletePolice(String account);
	//识别老人信息
	public OldMan findOldman(OldMan oldman);
}
