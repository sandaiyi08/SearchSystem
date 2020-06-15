package com.mlxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.Policeman;

/**
 * Filename: PolicemanDao.java
 * 
 * ·警察数据访问层
 * 
 * @author Luor
 * @version 1.0
 */

@Repository
public interface PolicemanDao {
	// 警察登录
	public Policeman findPolice(@Param("account")String account,@Param("password")String password);
	// 警察删除
	public Integer deletePolice(String account);
	// 警察信息
	public List<Policeman> selectAllPolicemanList();
	// 查找警察信息
	public Policeman getPolicemanByAccount(String account);
	// 添加警察
	public Integer insertPoliceman(Policeman policeman);
	// 识别老人信息
	public OldMan findOldman(OldMan oldman);
}
