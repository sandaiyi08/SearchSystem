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
 * ������Ա���ݷ��ʲ�
 * 
 * @author Luor
 * @version 1.0
 */

@Repository
public interface ManagerDao {
	
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
	 * ���޸ľ�����Ϣ
	 * @param policeman
	 * @return
	 */
	public Integer updatePolice(Policeman policeman);
	
	/**
	 * ������ɾ��
	 * @param account
	 * @return
	 */
	public Integer deletePolice(String account);
	
	/**
	 * ���޸��û�����Ӧ��ͥ��Ա��Ϣ
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user);
	
	/**
	 * ���޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public Integer updateOnlyUser(User user);
	
	/**
	 * ���û�ɾ��
	 * @param tel
	 * @return
	 */
	public Integer deleteUser(String tel);
	
	/**
	 * ��������Ϣɾ��
	 * @param oldManId
	 * @return
	 */
	public Integer deleteOldMan(Integer oldManId);
	
	/**
	 * ������Ա���
	 * @param manager
	 * @return
	 */
	public Integer insertManager(Manager manager);
	
	/**
	 * ������Ա��Ϣɾ��
	 * @param account
	 * @return
	 */
	public Integer deleteManager(String account);
	
}
