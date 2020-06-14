package com.mlxt.service;

import org.apache.ibatis.annotations.Param;

import com.mlxt.pojo.Family;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.User;

/**
 * Filename: UserService.java
 * 
 * ·用户业务层接口
 * 
 * @author Luor
 * @version 1.0
 */
public interface UserService {
	//家属登陆
	public User findUser(@Param("tel")String tel,@Param("password")String password);
	//注册
	public Integer insertUser(User user);
	//老人信息采集
	public Integer insertOldman(OldMan oldman);
	//信息修改
	public Integer updateOldman(OldMan oldman);
	//家属信息修改
	public Integer updateFamily(Family family);
}
