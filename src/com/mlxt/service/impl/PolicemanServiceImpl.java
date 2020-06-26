package com.mlxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlxt.dao.PolicemanDao;
import com.mlxt.pojo.Image;
import com.mlxt.pojo.OldMan;
import com.mlxt.pojo.Policeman;
import com.mlxt.service.PolicemanService;

/**
 * Filename: PolicemanServiceImpl.java
 * 
 * ·警察业务层实现
 * 
 * @author Luor
 * @version 1.0
 */

@Service
public class PolicemanServiceImpl implements PolicemanService {
	
	@Autowired
	private PolicemanDao policemanDao;

	@Override
	public Policeman findPolice(String account, String password) {
		return this.policemanDao.findPolice(account, password);
	}

	@Override
	public OldMan findOldmanById(Integer oldManId) {
		return this.policemanDao.findOldmanById(oldManId);
	}

	@Override
	public List<Image> findImageList() {
		return this.policemanDao.findImageList();
	}

}
