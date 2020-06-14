package com.mlxt.service;

import org.apache.ibatis.annotations.Param;

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
	//�����¼
	public Policeman findPolice(@Param("account")String account,@Param("password")String password);
	//����ɾ��
	public Integer deletePolice(String account);
	//ʶ��������Ϣ
	public OldMan findOldman(OldMan oldman);
}
