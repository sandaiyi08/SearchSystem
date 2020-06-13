package com.mlxt.common.utils;

/**
 * Filename: BasePojo.java
 * 
 * ·所有实体类的父类，定义行数，用于分页
 * 
 * @author Luor
 * @version 1.0
 */
public class BasePojo {
	private Integer rows;//所取行数
	private Integer startRow;//起始行
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
}
