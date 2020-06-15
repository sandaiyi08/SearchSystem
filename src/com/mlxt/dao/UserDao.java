package com.mlxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.Family;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.User;

/**
 * Filename: UserDao.java
 * 
 * ·用户数据访问层
 * 
 * @author Luor
 * @version 1.0
 */

@Repository
public interface UserDao {
	// 家属登陆
	public User findUser(@Param("tel")String tel,@Param("password")String password);
	// 注册
	public Integer insertUser(User user);
	// 老人信息采集
	public Integer insertOldman(OldMan oldman);
	// 信息修改
	public Integer updateOldman(OldMan oldman);
	// 家属信息修改
	public Integer updateFamily(Family family);
	// 家庭信息
	public List<Family> selectFamilyList(String tel);
	// 用户信息
	public List<User> selectAllUserList();
}
