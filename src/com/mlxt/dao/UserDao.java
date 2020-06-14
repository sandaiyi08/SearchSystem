package com.mlxt.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.Family;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.User;

/**
 * Filename: UserDao.java
 * 
 * ���û����ݷ��ʲ�
 * 
 * @author Luor
 * @version 1.0
 */

@Repository
public interface UserDao {
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
