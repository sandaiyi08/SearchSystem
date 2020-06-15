package com.mlxt.service;

import java.util.List;

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
	// �����¼
	public Policeman findPolice(@Param("account")String account,@Param("password")String password);
	// ����ɾ��
	public Integer deletePolice(String account);
	// ������Ϣ
	public List<Policeman> selectAllPolicemanList();
	// ���Ҿ�����Ϣ
	public Policeman getPolicemanByAccount(String account);
	// ��Ӿ���
	public Integer insertPoliceman(Policeman policeman);
	// ʶ��������Ϣ
	public OldMan findOldman(OldMan oldman);
}
