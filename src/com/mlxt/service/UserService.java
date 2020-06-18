package com.mlxt.service;

import java.util.List;

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
	
	/**
	 * ·家属登陆
	 * @param tel
	 * @param password
	 * @return
	 */
	public User findUser(@Param("tel")String tel,@Param("password")String password);
	
	/**
	 * ·注册
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user);
	
	/**
	 * ·老人信息采集
	 * @param oldMan
	 * @return
	 */
	public Integer insertOldMan(OldMan oldMan);
	
	/**
	 * ·家庭信息采集
	 * @param family
	 * @return
	 */
	public Integer insertFamily(Family family);
	
	/**
	 * ·老人信息修改
	 * @param oldMan
	 * @return
	 */
	public Integer updateOldMan(OldMan oldMan);
	
	/**
	 * ·家属信息修改
	 * @param family
	 * @return
	 */
	public Integer updateFamily(Family family);
	
	/**
	 * ·家庭信息查询
	 * @param tel
	 * @return
	 */
	public List<Family> selectFamilyList(String tel);
	
	/**
	 * ·用户信息查询
	 * @return
	 */
	public List<User> selectAllUserList();
	
	/**
	 * ·通过老人信息查找老人ID
	 * @param oldMan
	 * @return
	 */
	public Integer findOldManIdByOldMan(OldMan oldMan);
	
	/**
	 * ·通过家庭信息查找老人ID
	 * @param family
	 * @return
	 */
	public Integer findOldManIdByFamily(Family family);
	
	/**
	 * ·查找用户名
	 * @param familyTel
	 * @return
	 */
	public String findUserName(String familyTel);
	
}
