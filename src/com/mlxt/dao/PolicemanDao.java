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
