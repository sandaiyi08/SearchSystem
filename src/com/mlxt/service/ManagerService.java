package com.mlxt.service;

import org.apache.ibatis.annotations.Param;

import com.mlxt.pojo.Manager;

/**
 * Filename: ManagerService.java
 * 
 * ������Աҵ���ӿ�
 * 
 * @author Luor
 * @version 1.0
 */
public interface ManagerService {
	// ���ҹ���Ա
	public Manager findManager(@Param("account")String account,@Param("password")String password);
}
