package com.mlxt.service;

import org.apache.ibatis.annotations.Param;

import com.mlxt.pojo.Family;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.User;

/**
 * Filename: UserService.java
 * 
 * ���û�ҵ���ӿ�
 * 
 * @author Luor
 * @version 1.0
 */
public interface UserService {
	//������½
	public User findUser(@Param("tel")String tel,@Param("password")String password);
	//ע��
	public Integer insertUser(User user);
	//������Ϣ�ɼ�
	public Integer insertOldman(OldMan oldman);
	//��Ϣ�޸�
	public Integer updateOldman(OldMan oldman);
	//������Ϣ�޸�
	public Integer updateFamily(Family family);
}
