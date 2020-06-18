package com.mlxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.Policeman;

/**
 * Filename: PolicemanDao.java
 * 
 * ���������ݷ��ʲ�
 * 
 * @author Luor
 * @version 1.0
 */

@Repository
public interface PolicemanDao {
	
	/**
	 * �������¼
	 * @param account
	 * @param password
	 * @return
	 */
	public Policeman findPolice(@Param("account")String account,@Param("password")String password);
	
	/**
	 * ������ɾ��
	 * @param account
	 * @return
	 */
	public Integer deletePolice(String account);
	
	/**
	 * ��������Ϣ
	 * @return
	 */
	public List<Policeman> selectAllPolicemanList();
	
	/**
	 * �����Ҿ�����Ϣ
	 * @param account
	 * @return
	 */
	public Policeman getPolicemanByAccount(String account);
	
	/**
	 * ����Ӿ���
	 * @param policeman
	 * @return
	 */
	public Integer insertPoliceman(Policeman policeman);
	
	/**
	 * ��ʶ��������Ϣ
	 * @param oldman
	 * @return
	 */
	public OldMan findOldman(OldMan oldman);
	
}
