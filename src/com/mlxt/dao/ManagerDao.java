package com.mlxt.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.Manager;

/**
 * Filename: ManagerDao.java
 * 
 * ������Ա���ݷ��ʲ�
 * 
 * @author Luor
 * @version 1.0
 */

@Repository
public interface ManagerDao {
	// ���ҹ���Ա
	public Manager findManager(@Param("account")String account,@Param("password")String password);
}
