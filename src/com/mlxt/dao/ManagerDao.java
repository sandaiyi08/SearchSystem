package com.mlxt.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.Manager;

/**
 * Filename: ManagerDao.java
 * 
 * ·管理员数据访问层
 * 
 * @author Luor
 * @version 1.0
 */

@Repository
public interface ManagerDao {
	// 查找管理员
	public Manager findManager(@Param("account")String account,@Param("password")String password);
}
