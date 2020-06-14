package com.mlxt.dao;

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
	//�����¼
	public Policeman findPolice(@Param("account")String account,@Param("password")String password);
	//����ɾ��
	public Integer deletePolice(String account);
	//ʶ��������Ϣ
	public OldMan findOldman(OldMan oldman);
}
