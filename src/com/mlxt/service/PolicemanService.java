package com.mlxt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mlxt.pojo.Image;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.Policeman;

/**
 * Filename: PolicemanService.java
 * 
 * ������ҵ���ӿ�
 * 
 * @author Luor
 * @version 1.0
 */
public interface PolicemanService {
	
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
