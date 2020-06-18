package com.mlxt.service;

import java.util.List;

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
	
	/**
	 * ��������½
	 * @param tel
	 * @param password
	 * @return
	 */
	public User findUser(@Param("tel")String tel,@Param("password")String password);
	
	/**
	 * ��ע��
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user);
	
	/**
	 * ��������Ϣ�ɼ�
	 * @param oldMan
	 * @return
	 */
	public Integer insertOldMan(OldMan oldMan);
	
	/**
	 * ����ͥ��Ϣ�ɼ�
	 * @param family
	 * @return
	 */
	public Integer insertFamily(Family family);
	
	/**
	 * ��������Ϣ�޸�
	 * @param oldMan
	 * @return
	 */
	public Integer updateOldMan(OldMan oldMan);
	
	/**
	 * ��������Ϣ�޸�
	 * @param family
	 * @return
	 */
	public Integer updateFamily(Family family);
	
	/**
	 * ����ͥ��Ϣ��ѯ
	 * @param tel
	 * @return
	 */
	public List<Family> selectFamilyList(String tel);
	
	/**
	 * ���û���Ϣ��ѯ
	 * @return
	 */
	public List<User> selectAllUserList();
	
	/**
	 * ��ͨ��������Ϣ��������ID
	 * @param oldMan
	 * @return
	 */
	public Integer findOldManIdByOldMan(OldMan oldMan);
	
	/**
	 * ��ͨ����ͥ��Ϣ��������ID
	 * @param family
	 * @return
	 */
	public Integer findOldManIdByFamily(Family family);
	
	/**
	 * �������û���
	 * @param familyTel
	 * @return
	 */
	public String findUserName(String familyTel);
	
}
