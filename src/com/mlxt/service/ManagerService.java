package com.mlxt.service;

import org.apache.ibatis.annotations.Param;

import com.mlxt.pojo.Manager;

/**
 * Filename: ManagerService.java
 * 
 * ·管理员业务层接口
 * 
 * @author Luor
 * @version 1.0
 */
public interface ManagerService {
	// 查找管理员
	public Manager findManager(@Param("account")String account,@Param("password")String password);
}
