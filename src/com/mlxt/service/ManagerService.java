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
 * ������Աҵ���ӿ�
 * 
 * @author Luor
 * @version 1.0
 */
public interface ManagerService {
	
	/**
	 * �����ҹ���Ա
	 * @param account
	 * @param password
	 * @return
	 */
	public Manager findManager(@Param("account")String account,@Param("password")String password);
	
	/**
	 * ����ȡ�û�����
	 * @param user
	 * @return
	 */
	public Integer findUserCount(User user);
	
	/**
	 * ����ȡ�û��б�
	 * @param user
	 * @return
	 */
	public List<User> findUserList(User user);
	
	/**
	 * ����ȡ��������
	 * @param policeman
	 * @return
	 */
	public Integer findPoliceCount(Policeman policeman);
	
	/**
	 * ����ȡ�����б�
	 * @param policeman
	 * @return
	 */
	public List<Policeman> findPoliceList(Policeman policeman);
	
	/**
	 * ����Ӿ���
	 * @param policeman
	 * @return
	 */
	public Integer insertPoliceman(Policeman policeman);
	
	/**
	 * ������ɾ��
	 * @param account
	 * @return
	 */
	public Integer deletePolice(String account);
	
	/**
	 * ���޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user);
	
	/**
	 * ����ȡ�û�ҳ��
	 * @param user
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<User> findUserPage(User user, Integer page, Integer rows);
	
	/**
	 * ����ȡ����ҳ��
	 * @param policeman
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<Policeman> findPolicePage(Policeman policeman, Integer page, Integer rows);
	
}
