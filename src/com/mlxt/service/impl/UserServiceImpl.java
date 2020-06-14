package com.mlxt.service.impl;

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
	public Integer insertOldman(OldMan oldman) {
		return this.userDao.insertOldman(oldman);
	}

	@Override
	public Integer updateOldman(OldMan oldman) {
		return this.userDao.updateOldman(oldman);
	}

	@Override
	public Integer updateFamily(Family family) {
		return this.userDao.updateFamily(family);
	}

}
