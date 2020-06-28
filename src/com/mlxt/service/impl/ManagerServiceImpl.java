package com.mlxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlxt.common.utils.Page;
import com.mlxt.dao.ManagerDao;
import com.mlxt.pojo.Manager;
import com.mlxt.pojo.Policeman;
import com.mlxt.pojo.User;
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
	public Manager findManager(String account,String password) {
		return this.managerDao.findManager(account, password);
	}
	
	@Override
	public Integer findUserCount(User user) {
		return this.managerDao.findUserCount(user);
	}

	@Override
	public List<User> findUserList(User user) {
		return this.managerDao.findUserList(user);
	}

	@Override
	public Integer findPoliceCount(Policeman policeman) {
		return this.managerDao.findPoliceCount(policeman);
	}

	@Override
	public List<Policeman> findPoliceList(Policeman policeman) {
		return this.managerDao.findPoliceList(policeman);
	}
	
	@Override
	public Integer insertPoliceman(Policeman policeman) {
		return this.managerDao.insertPoliceman(policeman);
	}
	
	@Override
	public Integer updatePolice(Policeman policeman) {
		return this.managerDao.updatePolice(policeman);
	}
	
	public Integer deletePolice(String account) {
		return this.managerDao.deletePolice(account);
	}
	
	@Override
	public Integer updateUser(User user) {
		return this.managerDao.updateUser(user);
	}
	
	@Override
	public Integer updateOnlyUser(User user) {
		return this.managerDao.updateOnlyUser(user);
	}

	@Override
	public Integer deleteUser(String tel) {
		return this.managerDao.deleteUser(tel);
	}

	@Override
	public Integer deleteOldMan(Integer oldManId) {
		return this.managerDao.deleteOldMan(oldManId);
	}
	
	@Override
	public Integer insertManager(Manager manager) {
		return this.managerDao.insertManager(manager);
	}

	@Override
	public Integer deleteManager(String account) {
		return this.managerDao.deleteManager(account);
	}
	
	@Override
	public Page<User> findUserPage(User user, Integer page, Integer rows) {
		user.setStartRow((page-1)*rows);
		user.setRows(rows);
		Page<User> userPage = new Page<User>();
		userPage.setTotal(this.managerDao.findUserCount(user));
		userPage.setRows(this.managerDao.findUserList(user));
		userPage.setPage(page);
		userPage.setSize(rows);
		return userPage;
	}

	@Override
	public Page<Policeman> findPolicePage(Policeman policeman, Integer page, Integer rows) {
		policeman.setStartRow((page-1)*rows);
		policeman.setRows(rows);
		Page<Policeman> policePage = new Page<Policeman>();
		policePage.setTotal(this.managerDao.findPoliceCount(policeman));
		policePage.setRows(this.managerDao.findPoliceList(policeman));
		policePage.setPage(page);
		policePage.setSize(rows);
		return policePage;
	}

}
