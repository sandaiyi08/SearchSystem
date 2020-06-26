package com.mlxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.Image;
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
	 * ��ʶ��������Ϣ
	 * @param oldManId
	 * @return
	 */
	public OldMan findOldmanById(@Param("oldManId")Integer oldManId);
	
	/**
	 * ����ȡͼƬ��Ϣ
	 * @return
	 */
	public List<Image> findImageList();
	
}
