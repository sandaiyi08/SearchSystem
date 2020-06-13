package com.mlxt.common.utils;

import java.util.List;

/**
 * Filename: Page.java
 * 
 * ·页面类
 * 
 * @author Luor
 * @version 1.0
 */
public class Page<T> {
	
	private int page;   //当前页数
	private List<T> rows;
	private int size;   //每页行数
	private int total;   //分页总数
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
