package com.mlxt.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlxt.dao.ManagerDao;
import com.mlxt.pojo.Manager;
import com.mlxt.service.ManagerService;

/**
 * Filename: ManagerServiceImpl.java
 * 
 * ·管理员业务层实现
 * 
 * @author Luor
 * @version 1.0
 */

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerDao managerDao;

	@Override
	public Manager findManager(@Param("account")String account,@Param("password")String password) {
		return this.managerDao.findManager(account, password);
	}

}
