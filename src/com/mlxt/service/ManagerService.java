package com.mlxt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mlxt.common.utils.Page;
import com.mlxt.pojo.Manager;
import com.mlxt.pojo.Policeman;
import com.mlxt.pojo.User;

/**
 * Filename: ManagerService.java
 * 
 * ·管理员业务层接口
 * 
 * @author Luor
 * @version 1.0
 */
public interface ManagerService {
	
	/**
	 * ·查找管理员
	 * @param account
	 * @param password
	 * @return
	 */
	public Manager findManager(@Param("account")String account,@Param("password")String password);
	
	/**
	 * ·获取用户数量
	 * @param user
	 * @return
	 */
	public Integer findUserCount(User user);
	
	/**
	 * ·获取用户列表
	 * @param user
	 * @return
	 */
	public List<User> findUserList(User user);
	
	/**
	 * ·获取警察数量
	 * @param policeman
	 * @return
	 */
	public Integer findPoliceCount(Policeman policeman);
	
	/**
	 * ·获取警察列表
	 * @param policeman
	 * @return
	 */
	public List<Policeman> findPoliceList(Policeman policeman);
	
	/**
	 * ·添加警察
	 * @param policeman
	 * @return
	 */
	public Integer insertPoliceman(Policeman policeman);
	
	/**
	 * ·警察删除
	 * @param account
	 * @return
	 */
	public Integer deletePolice(String account);
	
	/**
	 * ·修改用户信息
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user);
	
	/**
	 * ·获取用户页面
	 * @param user
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<User> findUserPage(User user, Integer page, Integer rows);
	
	/**
	 * ·获取警察页面
	 * @param policeman
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<Policeman> findPolicePage(Policeman policeman, Integer page, Integer rows);
	
}
