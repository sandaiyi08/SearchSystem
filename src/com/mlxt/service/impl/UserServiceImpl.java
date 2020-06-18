package com.mlxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlxt.dao.UserDao;
import com.mlxt.pojo.Family;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.User;
import com.mlxt.service.UserService;

/**
 * Filename: UserServiceImpl.java
 * 
 * ·用户业务层实现
 * 
 * @author Luor
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(String tel, String password) {
		return this.userDao.findUser(tel, password);
	}

	@Override
	public Integer insertUser(User user) {
		return this.userDao.insertUser(user);
	}

	@Override
	public Integer insertOldMan(OldMan oldMan) {
		return this.userDao.insertOldMan(oldMan);
	}
	
	@Override
	public Integer insertFamily(Family family) {
		return this.userDao.insertFamily(family);
	}

	@Override
	public Integer updateOldMan(OldMan oldMan) {
		return this.userDao.updateOldMan(oldMan);
	}

	@Override
	public Integer updateFamily(Family family) {
		return this.userDao.updateFamily(family);
	}

	@Override
	public List<Family> selectFamilyList(String tel) {
		return this.userDao.selectFamilyList(tel);
	}

	@Override
	public List<User> selectAllUserList() {
		return this.userDao.selectAllUserList();
	}

	@Override
	public Integer findOldManIdByOldMan(OldMan oldMan) {
		return this.userDao.findOldManIdByOldMan(oldMan);
	}

	@Override
	public Integer findOldManIdByFamily(Family family) {
		return this.userDao.findOldManIdByFamily(family);
	}

	@Override
	public String findUserName(String familyTel) {
		return this.userDao.findUserName(familyTel);
	}

}
