package com.mlxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.Manager;
import com.mlxt.pojo.Policeman;
import com.mlxt.pojo.User;

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
	 * ·修改警察信息
	 * @param policeman
	 * @return
	 */
	public Integer updatePolice(Policeman policeman);
	
	/**
	 * ·警察删除
	 * @param account
	 * @return
	 */
	public Integer deletePolice(String account);
	
	/**
	 * ·修改用户与相应家庭成员信息
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user);
	
	/**
	 * ·修改用户信息
	 * @param user
	 * @return
	 */
	public Integer updateOnlyUser(User user);
	
	/**
	 * ·用户删除
	 * @param tel
	 * @return
	 */
	public Integer deleteUser(String tel);
	
	/**
	 * ·老人信息删除
	 * @param oldManId
	 * @return
	 */
	public Integer deleteOldMan(Integer oldManId);
	
	/**
	 * ·管理员添加
	 * @param manager
	 * @return
	 */
	public Integer insertManager(Manager manager);
	
	/**
	 * ·管理员信息删除
	 * @param account
	 * @return
	 */
	public Integer deleteManager(String account);
	
}
